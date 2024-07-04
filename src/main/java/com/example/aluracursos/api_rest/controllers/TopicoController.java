package com.example.aluracursos.api_rest.controllers;


import com.example.aluracursos.api_rest.domain.Topico.DatosRegistroTopico;
import com.example.aluracursos.api_rest.domain.Topico.TopicoRespuesta;
import com.example.aluracursos.api_rest.domain.Topico.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;


    @PostMapping
    @Transactional
    public ResponseEntity<DatosRegistroTopico> createTopico(@RequestBody @Valid DatosRegistroTopico dto) {
        DatosRegistroTopico createdTopico = topicoService.createTopico(dto);
        return ResponseEntity.status(201).body(createdTopico);
    }
}
