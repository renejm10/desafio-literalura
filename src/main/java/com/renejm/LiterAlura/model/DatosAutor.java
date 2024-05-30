package com.renejm.LiterAlura.model;

import com.fasterxml.jackson.annotation.JsonAlias;

public record DatosAutor(
        @JsonAlias("birth_year") Integer birth_year,
        @JsonAlias("death_year") Integer death_year,
        @JsonAlias("name") String nombre
) {
}
