package com.renejm.LiterAlura.repositorio;

import com.renejm.LiterAlura.model.Autor;
import com.renejm.LiterAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ILibroRepositorio extends JpaRepository<Autor, Long> {



    @Query("SELECT a from Autor a WHERE :year >= a.birth_year and  :year <= a.death_year ORDER BY a.birth_year DESC ")
    List<Autor> buscarAutorVivo(int year);


}


