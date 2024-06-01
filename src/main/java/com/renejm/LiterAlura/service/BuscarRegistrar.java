package com.renejm.LiterAlura.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.renejm.LiterAlura.model.*;
import org.json.JSONArray;

import java.util.ArrayList;
import java.util.List;

public class BuscarRegistrar{
    SolicitarDatos solicitarDatos = new SolicitarDatos();
    ConvertirDatos conversor = new ConvertirDatos();
    DatosAutor datosAutor;

    public DatosLibro getDatosLibro() {
        var json = solicitarDatos.obtenerDatos();
        System.out.println(json);
        DatosLibro datosLibro = conversor.obtenerDatos(json, DatosLibro.class);
        System.out.println(datosLibro);
        return datosLibro;
    }



}
