package com.example.aluracursos.api_rest.domain.curso;

public enum Categoria {
    PROGRAMACION("Programacion"),
    DESARROLLO_PERSONAL("Desarrollo_personal"),
    FRONT_END("Front_end"),
    BACK_END("Back_end");

    private String categoria;


    Categoria(String categoria){
        this.categoria = categoria;
    }
}
