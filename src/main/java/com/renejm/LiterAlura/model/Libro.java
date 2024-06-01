package com.renejm.LiterAlura.model;

import java.util.List;

public class Libro {
    private Long id;
    private String titulo;
    private List<Autor> autor;
    private Idiomas idioma;
    private Integer descargas;

    public Libro(DatosLibro datos, List<Autor> autor) {
        this.titulo = datos.titulo();
        this.autor = autor;
        this.idioma = Idiomas.fromString(String.valueOf(datos.idioma()));
        this.descargas = datos.descargas();

    }


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public Idiomas getIdioma() {
        return idioma;
    }

    public void setIdioma(Idiomas idioma) {
        this.idioma = idioma;
    }

    public Integer getDescargas() {
        return descargas;
    }

    public void setDescargas(Integer descargas) {
        this.descargas = descargas;
    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", autores=" + autor +
                ", idioma=" + idioma +
                ", descargas=" + descargas;
    }
}
