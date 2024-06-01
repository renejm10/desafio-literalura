package com.renejm.LiterAlura.model;

public enum Idiomas {
    INGLES("en"),
    ESPAÑOL("es"),
    FRANCES("fr");

    private String idiomasLibros;
    Idiomas (String idiomasLibros){
        this.idiomasLibros = idiomasLibros;
    }

    public static Idiomas fromString(String texto){
        for (Idiomas idiomas : Idiomas.values()){
            if (idiomas.idiomasLibros.equalsIgnoreCase(texto)){
                return idiomas;
            }
        }
        throw new IllegalArgumentException("Idioma " + texto + " no encontrado");
    }
}
