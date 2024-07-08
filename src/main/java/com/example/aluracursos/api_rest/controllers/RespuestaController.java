package com.example.aluracursos.api_rest.controllers;

import com.example.aluracursos.api_rest.domain.Topico.DatosTopicoRespuesta;
import com.example.aluracursos.api_rest.domain.respuesta.DatosActualizarRespuesta;
import com.example.aluracursos.api_rest.domain.respuesta.DatosRespuesta;
import com.example.aluracursos.api_rest.domain.respuesta.Respuesta;
import com.example.aluracursos.api_rest.domain.respuesta.RespuestaService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/respuestas")
public class RespuestaController {

    @Autowired
    RespuestaService respuestaService;

    @PostMapping
    @Transactional
    public ResponseEntity<DatosRespuesta> crearRespuesta(@RequestBody @Valid DatosRespuesta datosRespuesta){
        DatosRespuesta respuestaCreada = respuestaService.crearRespuesta(datosRespuesta);
        return ResponseEntity.status(201).body(respuestaCreada);
    }

    @GetMapping("/topico/{id}")
    public ResponseEntity<Page<Respuesta>> getRespuestasPorTopico(@PathVariable Long id, Pageable pageable) {
        Page<Respuesta> respuestas = respuestaService.getRespuestasPorTopico(id, pageable);
        return ResponseEntity.ok(respuestas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Respuesta> actualizarRespuesta(@PathVariable Long id, @RequestBody DatosActualizarRespuesta dto) {
        dto = new DatosActualizarRespuesta(id, dto.mensaje(), dto.fechaCreacion());
        Respuesta respuestaActualizada = respuestaService.actualizarRespuesta(dto);
        return ResponseEntity.ok(respuestaActualizada);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarRespuesta(@PathVariable Long id) {
        respuestaService.eliminarRespuesta(id);
        return ResponseEntity.noContent().build();
    }
}
