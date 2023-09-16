package br.com.santana.desafios.utils;

import java.util.List;

public class DesafiosCheckerUtils {
    public static void compareResultadoEsperado(List<String> resultado, List<String> esperado) {
        if(resultado.size() != esperado.size()) {
            System.out.println("Você falhou miseravelmente");
        }

        boolean sucesso = true;

        for (int i = 0; i < resultado.size(); i++) {
            sucesso = resultado.get(i).equals(esperado.get(i));
        }

        if (sucesso) {
            System.out.println("Parabéns, você está próximo de se tornar um code master!");
        } else {
            System.out.println("Quase lá, estude mais!");
        }
    }
}
