package com.example.aluracursos.api_rest.domain.respuesta;

import java.time.LocalDateTime;

public record DatosActualizarRespuesta(Long id, String mensaje, LocalDateTime fechaCreacion) {
}
