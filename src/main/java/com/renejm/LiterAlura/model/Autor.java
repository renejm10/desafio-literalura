package com.renejm.LiterAlura.model;

import java.util.List;

public class Autor {
    private Long id;
    private Integer birth_year;
    private Integer death_year;
    private String nombre;
    private List<Libro> libro;

    public Autor() {}

    public Autor(DatosAutor autor) {
        this.birth_year = autor.birth_year();
        this.death_year = autor.death_year();
        this.nombre = autor.nombre();
    }

    public Integer getBirth_year() {
        return birth_year;
    }

    public void setBirth_year(Integer birth_year) {
        this.birth_year = birth_year;
    }

    public Integer getDeath_year() {
        return death_year;
    }

    public void setDeath_year(Integer death_year) {
        this.death_year = death_year;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return
                "birth_year=" + birth_year +
                ", death_year=" + death_year +
                ", nombre='" + nombre + '\'' +
                ", libro=" + libro;
    }
}
