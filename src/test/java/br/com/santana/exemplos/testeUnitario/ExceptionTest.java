package br.com.santana.exemplos.testeUnitario;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

public class ExceptionTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test(expected = IndexOutOfBoundsException.class)
    public void testOutOfBound(){
        new ArrayList<Object>().get(0);
    }

    @Test
    public void testThrowExpectedException() throws IndexOutOfBoundsException{
        List<String> list = new ArrayList<>();

        thrown.expect(IndexOutOfBoundsException.class);
        thrown.expectMessage("Index 0 out of bounds for length 0");
        list.get(0);
    }

    @Test
    public void testTryCatchIdiom(){
        try {
            new ArrayList<String>().get(0);
            fail("Esperado que IndexOutOfBoundsException seja lançada!");
        }catch (IndexOutOfBoundsException e){
            assertThat(e.getMessage(), is("Index 0 out of bounds for length 0"));
        }
    }
}
