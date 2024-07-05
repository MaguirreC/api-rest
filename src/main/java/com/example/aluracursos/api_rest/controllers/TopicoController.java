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
}
