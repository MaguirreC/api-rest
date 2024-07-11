package com.example.aluracursos.api_rest.controllers;

import com.example.aluracursos.api_rest.domain.usuario.DatosRegistroUsuario;
import com.example.aluracursos.api_rest.domain.usuario.UsuarioRepository;
import com.example.aluracursos.api_rest.domain.usuario.UsuarioService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    UsuarioService usuarioService;


    @PostMapping
    @Transactional
    public ResponseEntity<DatosRegistroUsuario> registarUsuario(@RequestBody @Valid DatosRegistroUsuario datos){
        DatosRegistroUsuario usuarioCreado = usuarioService.registroUsuario(datos);
        return ResponseEntity.status(201).body(usuarioCreado);
    }
    
}
