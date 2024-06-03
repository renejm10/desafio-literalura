package com.renejm.LiterAlura.repositorio;

import com.renejm.LiterAlura.model.Autor;
import com.renejm.LiterAlura.model.Idiomas;
import com.renejm.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILibroRepositorio extends JpaRepository<Autor, Long> {

    Optional<Autor>findByNombre(String nombre);

    @Query("SELECT l FROM Autor a JOIN a.libro l WHERE l.titulo ILIKE %:titulo%")
    Optional<Libro>buscarPorTitulo(String titulo);

    @Query("SELECT a from Autor a WHERE :year >= a.birth_year and  :year <= a.death_year ORDER BY a.birth_year DESC ")
    List<Autor> buscarAutorVivo(int year);

    @Query("SELECT l from Autor a JOIN a.libro l WHERE l.idioma = :idioma")
    List<Libro>buscarPorIdioma(Idiomas idioma);

    @Query("select l FROM Autor a JOIN a.libro l order by l.descargas LIMIT 10")
    List<Libro>top10Libros();


}


