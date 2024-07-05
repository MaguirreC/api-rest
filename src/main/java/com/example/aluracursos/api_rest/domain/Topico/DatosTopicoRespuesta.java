package com.example.aluracursos.api_rest.domain.Topico;

import java.security.Timestamp;
import java.time.LocalDateTime;

public record DatosTopicoRespuesta(Long id, String titulo, String mensaje, LocalDateTime fechaCreacion, String cursoNombre) {

    public DatosTopicoRespuesta(Topico topico) {
        this(topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getCurso().getNombre());
    }

}
