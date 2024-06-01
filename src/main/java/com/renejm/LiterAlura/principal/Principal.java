package com.renejm.LiterAlura.principal;

import java.util.Scanner;

public class Principal {
        Scanner sc = new Scanner(System.in);
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
            opcion = sc.nextInt();

            switch (opcion){
                case 1:

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
}
