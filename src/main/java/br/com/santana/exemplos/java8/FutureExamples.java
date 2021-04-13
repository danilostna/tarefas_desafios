package br.com.santana.exemplos.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExamples {
    private static final ExecutorService threads = Executors.newFixedThreadPool(3);

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Casa casa = new Casa(new Quarto());
//        casa.obterAfazeres().forEach(atividade -> threads.execute(atividade::realizar));
        List<Future<?>> futureList = new ArrayList<>();
        for (Atividade atividade : casa.obterAfazeres()) {
            Future<?> submit = threads.submit(atividade::realizar);
            futureList.add(submit);
        }
//        List<? extends Future<?>> futureList = list;
        while (true){
            int atividadesPendentes = 0;
            List<Future<?>> copiaFutureList = new ArrayList<>();
            copiaFutureList.addAll(futureList);
            for (Future future: copiaFutureList) {
                if(future.isDone()){
                    System.out.println("Atividade concluída: "+future.get());
                    futureList.remove(future);
                } else{
                    atividadesPendentes++;
                }
            }

            if(futureList.stream().allMatch(Future::isDone)){
                System.out.println("Terminou!");
                break;
            }

            System.out.println("Número de atividades pendentes: "+atividadesPendentes);
            Thread.sleep(500);
        }

        threads.shutdown();
    }
}

class Casa{
    private List<Comodo> comodos;

    Casa(Comodo... comodos){this.comodos = Arrays.asList(comodos);}

    List<Atividade> obterAfazeres(){
        return this.comodos.stream()
                .map(Comodo::obterAfazeres)
                .reduce(new ArrayList<Atividade>(), (pivo, atividades) -> {
                    pivo.addAll(atividades);
                    return pivo;
                });
    }
}

@FunctionalInterface
interface Atividade{
    String realizar() throws InterruptedException;
}

abstract class Comodo {
    abstract List<Atividade> obterAfazeres();
}

class Quarto extends Comodo{

    @Override
    List<Atividade> obterAfazeres() {
        return Arrays.asList(
                this::arrumarCama,
                this::arrumarGuardaRoupas,
                this::varrerQuarto
        );
    }

    private String arrumarGuardaRoupas() throws InterruptedException {
        String acao = "Arrumando o Guarda Roupas";
//        System.out.println(acao);
        Thread.sleep(10000);
        return acao;
    }

    private String varrerQuarto() throws InterruptedException {
        String acao = "Varrendo o Quarto";
//        System.out.println(acao);
        Thread.sleep(6000);
        return acao;
    }

    private String arrumarCama() throws InterruptedException {
        String acao = "Arrumando a Cama";
//        System.out.println(acao);
        Thread.sleep(3000);
        return acao;
    }
}
