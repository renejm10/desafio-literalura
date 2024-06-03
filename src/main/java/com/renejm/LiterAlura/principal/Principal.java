package com.renejm.LiterAlura.principal;

import com.renejm.LiterAlura.model.Autor;
import com.renejm.LiterAlura.model.DatosAutor;
import com.renejm.LiterAlura.model.DatosLibro;
import com.renejm.LiterAlura.model.Libro;
import com.renejm.LiterAlura.repositorio.ILibroRepositorio;
import com.renejm.LiterAlura.service.Buscar;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;


public class Principal {
    Scanner sc = new Scanner(System.in);
    Buscar buscarRegistro = new Buscar();
    List<Libro>libros = new ArrayList<>();
    private ILibroRepositorio repositorio;


    public Principal(ILibroRepositorio repository) {
        this.repositorio = repository;
    }


    public void menu(){
        var opcion = -1;
        while(opcion != 0){
            var menu="";
            menu = """
                    1 - Buscar y Registrar Libro por Titulo
                    2 - Libros Registrados
                    3 - Autores Registrados
                    4 - Autores Vivos en Determinado Año
                    5 - Libros por idioma
                    6 - Top 5 Libros mas descargados
                    0 - SALIR
                    """;
            System.out.println(menu);
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    buscarRegistrar();
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta!, Vuelva a elegir una opcion.\n");
                    break;
            }
        }
    }

    private void buscarRegistrar() {
        DatosLibro datosLibro = buscarRegistro.getDatosLibro();
        DatosAutor datosAutor = buscarRegistro.getDatosAutor();
        Autor autor = new Autor(datosAutor);
        Libro libro = new Libro(autor, datosLibro);

        List<Libro>libroLista = new ArrayList<>();
        libroLista.add(libro);
        autor.setLibro(libroLista);

        System.out.println(autor);
        System.out.println(libro);
        repositorio.save(autor);






    }




}
