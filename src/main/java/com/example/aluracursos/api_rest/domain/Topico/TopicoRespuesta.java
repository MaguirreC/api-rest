package com.example.aluracursos.api_rest.domain.Topico;

import java.sql.Timestamp;

public record TopicoRespuesta(
        Long id,
        String titulo,
        String mensaje,
        Timestamp fechaCreacion,
        String status,
        Long cursoId
) {
}
