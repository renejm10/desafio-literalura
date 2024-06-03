package com.renejm.LiterAlura.principal;

import com.renejm.LiterAlura.model.*;
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
                    \n1 - Buscar y Registrar Libro por Titulo
                    2 - Libros Registrados
                    3 - Autores Registrados
                    4 - Autores Vivos en Determinado Año
                    5 - Libros por idioma
                    6 - Top 10 Libros mas descargados
                    0 - SALIR
                    """;
            System.out.println(menu);
            System.out.println("Ingrese una opcion: ");
            opcion = sc.nextInt();

            switch (opcion){
                case 1:
                    buscar();
                    break;
                case 2:
                    librosRegistrados();
                    break;
                case 3:
                    autoresRegistrados();
                    break;
                case 4:
                    autoresVivos();
                    break;
                case 5:
                    libroIdioma();
                    break;
                case 6:
                    top10libros();
                    break;
                default:
                    System.out.println("Ingreso una opcion incorrecta!, Vuelva a elegir una opcion.\n");
                    break;
            }
        }
    }

    private void buscar() {
        DatosLibro datosLibro = buscarRegistro.getDatosLibro();
        DatosAutor datosAutor = buscarRegistro.getDatosAutor();
        List<Libro>libroLista = new ArrayList<>();
        Autor autor = null;
        Libro libro = null;

        Optional<Autor>buscaAutor = repositorio.findByNombre(datosAutor.nombre());
        if(!(buscaAutor.isPresent())){
            autor = new Autor(datosAutor);
            libro = new Libro(autor,datosLibro);
            libroLista.add(libro);
            autor.setLibro(libroLista);
            repositorio.save(autor);
            System.out.println(libro);
        }else {
            Optional<Libro>buscaLibro = repositorio.buscarPorTitulo(datosLibro.titulo());
            if(!(buscaLibro.isPresent())){
                autor = buscaAutor.get();
                libro = new Libro(autor,datosLibro);
                libroLista.add(libro);
                autor.setLibro(libroLista);
                repositorio.save(autor);
                System.out.println(libro);
                System.out.println("Se registro exitosamente en la base de datos!");
            }else {
                System.out.println("Titulo: " + libro.getTitulo() + " Autores: " + datosAutor.nombre() +
                        " Idioma: " + datosLibro.idioma() + " Descargas: " + datosLibro.descargas());
                System.out.println("El libro ya existe en la base de datos");
            }
        }

    }

//    private void registrar() {
//        DatosLibro datosLibro = buscarRegistro.getDatosLibro();
//        DatosAutor datosAutor = buscarRegistro.getDatosAutor();
////        Autor autor = new Autor(datosAutor);
////        Libro libro = new Libro(autor, datosLibro);
////        List<Libro>libroLista = new ArrayList<>();
////        libroLista.add(libro);
////        autor.setLibro(libroLista);
////
////        System.out.println(autor);
////        System.out.println(libro);
////        repositorio.save(autor);
//    }

    private void autoresRegistrados() {
        List<Autor> autores = repositorio.findAll();
        autores.forEach(System.out::println);
    }

    private void librosRegistrados() {
        List<Autor>librosRegistrados = repositorio.findAll();
        librosRegistrados.stream()
                .map(Autor::getLibro)
                .forEach(System.out::println);
    }

    private void autoresVivos() {
        System.out.println("Ingrese en que rango de años desea ver los autores vivos: ");
        int year = sc.nextInt();
        List<Autor> autorVivo = repositorio.buscarAutorVivo(year);
        autorVivo.forEach(System.out::println);
    }

    private void libroIdioma() {
        System.out.println("Ingrese el idioma del cual quisiera ver libros: ");
        var idioma = sc.next();
        var lang = Idiomas.fromString(idioma);
        List<Libro> libroIdioma = repositorio.buscarPorIdioma(lang);
        libroIdioma.forEach(System.out::println);
    }

    private void top10libros(){
        List<Libro>top10Libros = repositorio.top10Libros();
        top10Libros.forEach(System.out::println);
    }



}
