package com.renejm.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
        @JsonAlias("title")String titulo,
        @JsonAlias("authors")List<DatosAutor> autores,
        @JsonAlias("languages")List<String> idioma,
        @JsonAlias("download_count")Integer descargas
) {}
