package com.renejm.LiterAlura.principal;

import com.renejm.LiterAlura.model.DatosLibro;
import com.renejm.LiterAlura.model.JsonResultado;
import com.renejm.LiterAlura.model.Libro;
import com.renejm.LiterAlura.service.ConvertirDatos;
import com.renejm.LiterAlura.service.SolicitarDatos;

import java.util.Scanner;

public class Principal {
    Scanner sc = new Scanner(System.in);
    SolicitarDatos solicitarDatos = new SolicitarDatos();
    ConvertirDatos conversor = new ConvertirDatos();
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
                    System.out.println("Ingreso una opcion incorrecta!, Vuelva a elegir una opcion.");
                    break;
            }
        }
    }

    private JsonResultado getDatosLibro(){
        var json = solicitarDatos.obtenerDatos();
        System.out.println(json);
        JsonResultado resultado = conversor.obtenerDatos(json, JsonResultado.class);
        return resultado;
    }

    private void buscarRegistrar() {
        JsonResultado datos = getDatosLibro();


        System.out.println(datos);
    }

}
