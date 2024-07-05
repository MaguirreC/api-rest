package com.example.aluracursos.api_rest.domain.Topico;

import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record DatosRegistroTopico(String titulo,
                                  String mensaje,
                                  LocalDateTime fechaCreacion,
                                  String nombreCurso) {
    public DatosRegistroTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getCurso().getNombre()
        );
    }

}
