package br.com.santana.desafios;

import br.com.santana.desafios.utils.DesafiosCheckerUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UsernameValidator {

    public static final String regularExpression = "(^[a-zA-Z](\\w{7,29}))";

    public static void main(String[] args) {

        List<String> entrada = buildEntrada();
        List<String> resultado = new ArrayList<>();
        List<String> expected = buildExpected();

        for (String userName : entrada) {
            if (userName.matches(regularExpression)) {
                System.out.println("Valid");
                resultado.add("Valid");
            } else {
                System.out.println("Invalid");
                resultado.add("Invalid");
            }
        }

        DesafiosCheckerUtils.compareResultadoEsperado(resultado, expected);
    }

    private static List<String> buildEntrada() {
        return Arrays.asList("Julia",
                "Samantha",
                "Samantha_21",
                "1Samantha",
                "Samantha?10_2A",
                "JuliaZ007",
                "Julia@007",
                "_Julia007");
    }

    private static List<String> buildExpected() {
        return Arrays.asList("Invalid",
                "Valid",
                "Valid",
                "Invalid",
                "Invalid",
                "Valid",
                "Invalid",
                "Invalid");
    }

}
