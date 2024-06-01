package com.renejm.LiterAlura.service;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsumoApi {
    public String obtenerDatos(String url){
        //se crea cliente
        HttpClient client = HttpClient.newHttpClient();
        //se hace el request con url recibida
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        //se establece la respuesta en null para verificacion
        HttpResponse<String> response = null;

        //se verifica si se obtuvo una respuesta
        try{
            response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
        }catch (IOException e){
            throw new RuntimeException(e);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        String json = response.body();
        return json;
    }
}
