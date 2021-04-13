package br.com.santana.exemplos.java8;

public class CalculoFatorial {
    public static void main(String[] args) {
        long inicio = System.currentTimeMillis();
        IntStream.range(1, 100).forEach(System.out::println);
        long fim = System.currentTimeMillis();
        System.out.println("Tempo de Execução Serial: "+(fim-inicio));

        inicio = System.currentTimeMillis();
        IntStream.range(1, 100).parallel().forEach(System.out::println);
        fim = System.currentTimeMillis();
        System.out.println("Tempo de Execução Parallel: "+(fim-inicio));
    }

    public static long fatorial(long num){
        long fat = 1;

        for (long i = num; i >= 0; i--){
            if(i <= 0){
                fat += 1;
            }else{
                fat += i;
//                System.out.println("fat é igual a: "+fat);
            }
        }

//        System.out.println("Fatorial de "+num+" é: "+fat);
        return fat;
    }
}
