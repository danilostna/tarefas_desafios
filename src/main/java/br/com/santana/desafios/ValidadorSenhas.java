package br.com.santana.desafios;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ValidadorSenhas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;

        while ((line = br.readLine()) != null){
            boolean matches = line.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,32}$");

            if(matches){
                System.out.println("Senha valida.");
            }else{
                System.out.println("Senha invalida.");
            }
        }
    }
}
