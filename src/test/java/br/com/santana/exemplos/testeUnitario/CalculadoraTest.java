package br.com.santana.exemplos.testeUnitario;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalculadoraTest {
    @Test
    public void testSoma() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.soma(2, 3));
    }

    @Test
    public void testSomaMockito(){
        Calculadora calc = mock(Calculadora.class);
        when(calc.soma(3, 3)).thenReturn(10);

        assertEquals(10, calc.soma(3, 3));
    }


}