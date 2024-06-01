package com.renejm.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    @ManyToOne
    private Autor autor;
    @Enumerated(EnumType.STRING)
    private Idiomas idioma;
    private Integer descargas;

    public Libro(DatosLibro datos) {
        this.titulo = datos.titulo();
        this.autor = autor;
        this.idioma = Idiomas.fromString(datos.idioma().getFirst());
        this.descargas = datos.descargas();

    }


    public Libro() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
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
