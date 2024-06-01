package com.renejm.LiterAlura.repositorio;

import com.renejm.LiterAlura.model.Autor;
import com.renejm.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ILibroRepositorio extends JpaRepository<Libro, Long> {

    @Query("SELECT l from Libro l WHERE l.titulo ILIKE %:titulo% ")
    Optional<Libro> buscarTitulo(String titulo);

    @Query("SELECT a from Autor a WHERE a.nombre ILIKE %:nombre%")
    Optional<Autor> buscarAutorNombre(String nombre);
}