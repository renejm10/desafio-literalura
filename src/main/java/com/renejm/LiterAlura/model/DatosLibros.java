package com.renejm.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.persistence.ManyToOne;

import java.util.List;

public record DatosLibros(
         @JsonAlias("title") String titulo,
         @JsonAlias("subjects") List<String>temas,
         @JsonAlias("bookshelves") List<String> bookshelves,
         @JsonAlias("languages") List<String> idioma,
         @JsonAlias("download_count") Integer descargas
) {
}
