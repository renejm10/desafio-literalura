package com.renejm.LiterAlura.service;

import java.util.Scanner;

public class SolicitarDatos {
    ConsumoApi consumoApi = new ConsumoApi();
    Scanner teclado = new Scanner(System.in);
    private final String URL_BASE = "https://gutendex.com/books/?search=";

    public String obtenerDatos() {
        System.out.println("Ingrese titulo de libro a buscar para registrar: ");
        var tituloLibro = teclado.nextLine();
        var json = consumoApi.obtenerDatos(URL_BASE + tituloLibro.replace(" ", "+"));
        return json;
    }
}
