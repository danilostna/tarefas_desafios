package br.com.santana.exemplos.java11;

import java.io.IOException;
import java.net.ProxySelector;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class ApiHttp {
    static ExecutorService executor = Executors.newFixedThreadPool(6, new ThreadFactory() {
        @Override
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            return thread;
        }
    });

    public static void main(String[] args) throws Exception {
//        connection();
        http11Connection();
        http2Connection();
    }

    public static void http11Connection() throws IOException, InterruptedException {
        System.out.println("Rodando requisição HTTP 1.1");
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_1_1)
                .proxy(ProxySelector.getDefault())
                .build();

        HttpRequest request = HttpRequest
                .newBuilder(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                .build();

        long inicio = System.currentTimeMillis();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        long fim = System.currentTimeMillis();

        System.out.println("Status code: "+response.statusCode());
        System.out.println("Tempo de execução: "+(fim-inicio));
    }

    public static void http2Connection() throws IOException, InterruptedException {
        System.out.println("Rodando requisição HTTP 2.0");
        HttpClient client = HttpClient.newBuilder()
                .version(HttpClient.Version.HTTP_2)
                .proxy(ProxySelector.getDefault())
                .build();

        HttpRequest request = HttpRequest
                .newBuilder(URI.create("https://http2.akamai.com/demo/h2_demo_frame.html"))
                .build();

        long inicio = System.currentTimeMillis();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        long fim = System.currentTimeMillis();

        System.out.println("Status code: "+response.statusCode());
        System.out.println("Tempo de execução: "+(fim-inicio));
    }

    public static void connection() throws Exception {
        var request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("https://docs.oracle.com/javase/10/language/"))
                .build();

        var client = HttpClient.newHttpClient();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString());

        System.out.println("Status Code #"+response.statusCode());
        System.out.println("Headers #"+response.headers());
        System.out.println(response.body());
    }
}
