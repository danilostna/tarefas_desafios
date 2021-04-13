package br.com.santana.exemplos.testeUnitario;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class CalculadoraTest {

    @Test
    void soma() {
        Calculadora calc = new Calculadora();
        assertEquals(5, calc.soma(2, 3));
    }
}