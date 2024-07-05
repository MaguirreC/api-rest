package com.example.aluracursos.api_rest.domain.Topico;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record TopicoRespuesta(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        String status,
        Long cursoId
) {
}
