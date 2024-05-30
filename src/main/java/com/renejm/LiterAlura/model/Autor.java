package com.renejm.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="autores")
public class Autor {
    @Id
    private Long id;
    private Integer birth_year;
    private Integer death_year;
    private String nombre;
    @OneToMany(mappedBy = "autor",
            cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
