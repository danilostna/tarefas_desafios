package br.com.santana.desafios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class ConjuntosRuins {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String linha = br.readLine();
            if(linha.equals("0")){
                break;
            }

            Integer qtdPalavras = null;
            try{
                qtdPalavras = Integer.valueOf(linha);
            } catch (NumberFormatException e) {
                break;
            }
            List<String> palavras = new ArrayList<>();
            if(qtdPalavras != null){
                for (int i =0; i < qtdPalavras; i++){
                    palavras.add(br.readLine());
                }
                boolean anyMatch = palavras.stream().anyMatch(s1 -> {
                    List<String> complementar = new ArrayList<>(palavras);
                    complementar.remove(s1);
                    return complementar.stream().anyMatch(s2 -> {
                        return s1.startsWith(s2) || s2.startsWith(s1);
                    });
                });

                if(anyMatch){
                    System.out.println("Conjunto Ruim");
                }else{
                    System.out.println("Conjunto Bom");
                }
                palavras.clear();
            }
        }
    }
}
