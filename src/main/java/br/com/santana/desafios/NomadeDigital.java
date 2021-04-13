package br.com.santana.desafios;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class NomadeDigital {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String linha = br.readLine();
            if(linha.equals(".")){
                break;
            }
//            StringTokenizer st = new StringTokenizer(br.readLine());
            Map<String, String> mapAbreviacoes = gerarAbreviacoes(linha);


            List<String> keys = new ArrayList<>();
            keys.addAll(mapAbreviacoes.keySet());
            Collections.sort(keys);
            int contador = 0;
            String linhaAbreviada = "";
            for (String key: keys) {
                List<String> palavras = Arrays.asList(linha.split(" "));
                for (String palavra: palavras){
                    if(mapAbreviacoes.get(key).equals(palavra)){
                        linhaAbreviada += key+" ";
                        contador++;
                    }else{
                        linhaAbreviada += palavra+" ";
                    }
                }
            }
            System.out.println(linhaAbreviada.trim());
            System.out.println(contador);
            keys.stream().forEach(key -> System.out.println(key+" = "+mapAbreviacoes.get(key)));
        }
    }

    private static Map<String, String> gerarAbreviacoes(String linha) {
        Map<String, Integer> mapEconomia = new HashMap<>(); //Calculo qual palavra é melhor para abreviar
        Map<String, String> mapAbreviacoes = new HashMap<>(); //Faço um mapeamento de abreviações para palavras

        List<String> palavras = Arrays.asList(linha.split(" "));
        //Percorro todas as palavras para calcular a economia com abreviações e gerar as respectivas abreviações
        for (String palavra: palavras) {
            Integer economia = mapEconomia.get(palavra); //Tenta encontrar a palavra no map de economia
            String abreviacao = palavra.charAt(0)+"."; //Gera a abreviação da palavra

            if(economia == null){ //Se não encontrar um valor de economia, inicializa o valor
                economia = palavra.length()-2;
            }else{ //Se encontrar, continua o somatório
                economia += palavra.length()-2;
            }
            mapEconomia.put(palavra, economia);

            //Se já existir uma chave contendo essa abreviação
            if(mapAbreviacoes.containsKey(abreviacao)){
                //Busco a palavra referente à essa abreviação no map de abreviações
                String palavraAbreviada = mapAbreviacoes.get(abreviacao);

                //Se a economia gerada pela palavra abreviada atualmente for menor que da palavra sendo
                //iterada, deve-se substituir a palavra abreviada pela palavra sendo iterada.
                if(mapEconomia.get(palavraAbreviada) < economia){
                    mapAbreviacoes.put(abreviacao, palavra);
                }
            }
            //Se não encontrar nenhuma chave com a abreviacao, e o tamanho da palavra for maior que 2,
            // deve inicializar o map com esta abreviação
            else if(palavra.length() > 2){
                mapAbreviacoes.put(abreviacao, palavra);
            }
        }

        return mapAbreviacoes;
    }
}
