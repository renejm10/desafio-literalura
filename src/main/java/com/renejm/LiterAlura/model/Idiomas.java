package com.renejm.LiterAlura.model;

public enum Idiomas {
    INGLES("en","ingles"),
    ESPAÑOL("es","español"),
    FRANCES("fr","frances");

    private String idiomasLibros;
    private String idiomasEspanol;
    Idiomas (String idiomasLibros, String idiomasEspanol){
        this.idiomasLibros = idiomasLibros;
        this.idiomasEspanol = idiomasEspanol;
    }

    public static Idiomas fromString(String texto){
        for (Idiomas idiomas : Idiomas.values()){
            if (idiomas.idiomasLibros.equalsIgnoreCase(texto)){
                return idiomas;
            }
        }
        throw new IllegalArgumentException("Idioma " + texto + " no encontrado");
    }

    public static Idiomas fromEspanol(String espanol){
        for (Idiomas idiomas : Idiomas.values()){
            if (idiomas.idiomasEspanol.equalsIgnoreCase(espanol)){
                return idiomas;
            }
        }
        throw new IllegalArgumentException("Idioma " + espanol + " no encontrado");
    }
}
