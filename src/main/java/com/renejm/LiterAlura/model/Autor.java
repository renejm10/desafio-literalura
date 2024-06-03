package com.renejm.LiterAlura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer birth_year;
    private Integer death_year;
    private String nombre;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libro;

    public Autor(DatosAutor autor) {
        this.birth_year = autor.birth_year();
        this.death_year = autor.death_year();
        this.nombre = autor.nombre();
    }

    public Autor() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Libro> getLibro() {
        return libro;
    }

    public void setLibro(List<Libro> libro) {
        this.libro = libro;
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
                "Nombre='" + nombre +
                "Año de nacimiento=" + birth_year +
                ", Año de muerte=" + death_year +'\'';
    }
}
