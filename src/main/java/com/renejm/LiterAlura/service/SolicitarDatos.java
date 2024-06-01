package com.renejm.LiterAlura.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class SolicitarDatos {
    ConsumoApi consumoApi = new ConsumoApi();
    ObjectMapper mapper = new ObjectMapper();
    Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    String newJson;

    public String obtenerDatos() {
        System.out.println("Ingrese titulo de libro a buscar para registrar: ");
        var tituloLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + tituloLibro.replace(" ", "+"));
        try {
            JsonNode root = mapper.readTree(json);
            if(root.has("results")) {
                JsonNode results = root.get("results");
                newJson = results.get(0).toString();
            }
        } catch (Exception e) {
        }
        return newJson;
    }
}
