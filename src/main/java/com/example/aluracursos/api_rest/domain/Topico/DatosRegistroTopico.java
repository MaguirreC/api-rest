package com.example.aluracursos.api_rest.domain.Topico;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public record DatosRegistroTopico(@NotBlank String titulo,
                                 @NotBlank String mensaje,
                                  LocalDateTime fechaCreacion,
                                  @NotBlank String nombreAutor,
                                  @NotBlank String nombreCurso) {
    public DatosRegistroTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getAutor().getNombre(),
                topico.getCurso().getNombre()
        );
    }

}
