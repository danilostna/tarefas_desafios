package br.com.santana.desafios;

import br.com.santana.desafios.utils.DesafiosCheckerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PalavrasDuplicadas {

    public static void main(String[] args) {

        String regex = "\\b(\\w+)(?:\\W+\\1\\b)+";
        Pattern p = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);

        List<String> casoDeTeste = buildCasoDeTeste();
        List<String> resultado = new ArrayList<>();
        int index = 0;

        while (index < casoDeTeste.size()) {
            String input = casoDeTeste.get(index);

            Matcher m = p.matcher(input);

            // Check for subsequences of input that match the compiled pattern
            while (m.find()) {
                input = input.replaceAll(m.group(), m.group(1));
            }

            // Prints the modified sentence.
            System.out.println(input);
            resultado.add(input);
            index++;
        }

        checkResultado(resultado);
    }

    private static void checkResultado(List<String> resultado) {
        List<String> expected = new ArrayList<>();
        expected.add("Goodbye bye world");
        expected.add("Sam went to his business");
        expected.add("Reya is the best player in eye game");
        expected.add("in inthe");
        expected.add("Hello Ab");

        DesafiosCheckerUtils.compareResultadoEsperado(resultado, expected);
    }

    private static List<String> buildCasoDeTeste() {
        ArrayList<String> exemplos = new ArrayList<>();
        exemplos.add("Goodbye bye bye world world world");
        exemplos.add("Sam went went to to to his business");
        exemplos.add("Reya is is the the best player in eye eye game");
        exemplos.add("in inthe");
        exemplos.add("Hello hello Ab aB");

        return exemplos;
    }

}
