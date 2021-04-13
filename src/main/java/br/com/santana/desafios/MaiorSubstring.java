package br.com.santana.desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaiorSubstring {
    static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String linha1, linha2, maior, menor;
        while ((linha1 = in.readLine()) != null) {
            linha2 = in.readLine();

            if(linha1.length() > linha2.length()){
                menor = linha2;
                maior = linha1;
            }else{
                menor = linha1;
                maior = linha2;
            }

            int maxS = menor.length();
            boolean continuar = true;
            while (maxS > 0 && continuar){
                int diff = menor.length() - maxS;
                for(int i = 0; i <= diff; i++){
                    String substring = menor.substring(i, i + maxS);
                    if(maior.contains(substring)){
                        continuar = false;
                        maxS++;
                        break;
                    }
                }
                maxS--;
            }

            System.out.println(maxS);
        }
    }
}
