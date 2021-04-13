package br.com.santana.exemplos.testeUnitario;


import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RulesTest {
    @Rule
    public TemporaryFolder tmpFolder = new TemporaryFolder();

    @Test
    public void testCreateFileOnTemporaryFolder() throws IOException {
        File file = tmpFolder.newFile("file.txt");

        assertTrue(file.isFile());
        assertEquals(tmpFolder.getRoot(), file.getParentFile());
    }
}
