package com.example.aluracursos.api_rest.domain.Topico;

import java.time.LocalDateTime;

public record DatosActualizarTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Long cursoId
) {
}

