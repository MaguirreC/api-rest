package com.example.aluracursos.api_rest.controllers;


import com.example.aluracursos.api_rest.domain.Topico.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @Autowired
    private TopicoRepository topicoRepository;


    @PostMapping
    @Transactional
    public ResponseEntity<DatosRegistroTopico> createTopico(@RequestBody @Valid DatosRegistroTopico dto) {
        DatosRegistroTopico createdTopico = topicoService.createTopico(dto);
        return ResponseEntity.status(201).body(createdTopico);
    }

    @GetMapping
    public ResponseEntity<Page<DatosTopicoRespuesta>> listadoTopicos(Pageable paginacion) {
        Page<DatosTopicoRespuesta> topicos = topicoRepository.findAll(paginacion).map(DatosTopicoRespuesta::new);
        return ResponseEntity.ok(topicos);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DatosRegistroTopico> actualizarTopico(@PathVariable Long id, @RequestBody @Valid DatosActualizarTopico datos) {
        Topico updatedTopico = topicoService.actualizarTopico(id, datos);
        DatosRegistroTopico respuesta = new DatosRegistroTopico(
                updatedTopico.getTitulo(),
                updatedTopico.getMensaje(),
                updatedTopico.getFechaCreacion(),
                updatedTopico.getAutor().getNombre(),
                updatedTopico.getCurso().getNombre()  // Assuming this is how you map the curso
        );
        return ResponseEntity.ok(respuesta);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{id}")
    public ResponseEntity<DatosRegistroTopico> topicoById(@PathVariable Long id){
        DatosRegistroTopico topico = topicoService.topicoById(id);
        return ResponseEntity.ok(topico);
    }
}
