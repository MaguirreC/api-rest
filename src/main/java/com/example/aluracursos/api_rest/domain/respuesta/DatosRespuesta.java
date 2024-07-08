package com.example.aluracursos.api_rest.domain.respuesta;

import java.time.LocalDateTime;

public record DatosRespuesta(String mensaje,
                             LocalDateTime fechaCreacion,
                             String autor,
                             Long idTopico

                             ) {

    public DatosRespuesta(Respuesta respuesta){
        this(respuesta.getMensaje(),
                respuesta.getFechaCreacion(),
                respuesta.getAutor().getNombre(),
               respuesta.getTopico().getId()

        );

    }
}
