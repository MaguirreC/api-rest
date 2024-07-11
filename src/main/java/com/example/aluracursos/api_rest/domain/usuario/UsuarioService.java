package com.example.aluracursos.api_rest.domain.usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    UsuarioRepository usuarioRepository;

    public DatosRegistroUsuario registroUsuario(DatosRegistroUsuario datosRegistroUsuario){

        Usuario usuario = new Usuario();
        usuario.setNombre(datosRegistroUsuario.nombre());
        usuario.setEmail(datosRegistroUsuario.email());
        usuario.setContrasena(datosRegistroUsuario.contrasena());

        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return new DatosRegistroUsuario(usuarioGuardado);
    }

}
