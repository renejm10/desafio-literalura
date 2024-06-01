package com.renejm.LiterAlura.service;

import com.renejm.LiterAlura.model.*;

public class BuscarRegistrar {
    Libro libro;
    DatosLibro datosLibro;
    Autor autor;
    DatosAutor datosAutor;
    public void buscarRegistrar(JsonResultado datos){
        if (!(datos.libro().isEmpty())){
            datosLibro = datos.libro().getFirst();
            datosAutor = datosLibro.autor().getFirst();

            System.out.println(datos);
        }else{
            System.out.println("El libro no fue encontrado");
        }
    }
}
