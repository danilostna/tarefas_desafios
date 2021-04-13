package br.com.santana.desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EntrevistaEmbaracosa {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true){
            String line = br.readLine();
            if(line == null || line.isBlank()){
                break;
            }

            String palavraCorreta = line;
            boolean repetiu = false;
            for (int i = 0; i <= line.length()-1; i++){
                String substring = line.substring(i);
                String temp = line.substring(0, i);
                if(temp.endsWith(substring)){
                    palavraCorreta = temp;
                    System.out.println(palavraCorreta);
                    repetiu = true;
                }
            }

            if(!repetiu){
                System.out.println(palavraCorreta);
            }
        }
    }
}
