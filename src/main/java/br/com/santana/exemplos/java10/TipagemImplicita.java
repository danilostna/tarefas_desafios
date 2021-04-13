package br.com.santana.exemplos.java10;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.stream.Collectors;

public class TipagemImplicita {
    public static void main(String[] args) throws Exception {

    }

    public static void connection() throws Exception {
        // ATENÇÃO: palavra reservada 'var' só pode ser usada dentro de um escopo. Se tentar utilizar
        // em variáveis de classes, ou parâmetros de métodos, ou variáveis não inicializadas.
        // Qualquer um desses 3 cenários irá dar erro de compilação
        var url = new URL("https://docs.oracle.com/javase/10/language");
        var urlConnection = url.openConnection();
        var bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
        System.out.println(bufferedReader.lines().collect(Collectors.joining("\n")));
    }
}
