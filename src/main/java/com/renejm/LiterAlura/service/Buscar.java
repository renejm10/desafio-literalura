package com.renejm.LiterAlura.service;

import com.renejm.LiterAlura.model.*;

import java.util.Collections;
import java.util.List;

public class Buscar {
    SolicitarDatos solicitarDatos = new SolicitarDatos();
    ConvertirDatos conversor = new ConvertirDatos();
    DatosLibro datosLibro;
    List<DatosAutor> datosAutor;


    public DatosLibro getDatosLibro() {
        var json = solicitarDatos.obtenerDatos();
//        System.out.println(json);
        datosLibro = conversor.obtenerDatos(json, DatosLibro.class);
        return datosLibro;
    }

    public DatosAutor getDatosAutor() {
        datosAutor = datosLibro.autores();
        return datosAutor.getFirst();
    }










}
