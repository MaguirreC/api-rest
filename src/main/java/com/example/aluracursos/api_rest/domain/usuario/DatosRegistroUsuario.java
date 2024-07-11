package com.example.aluracursos.api_rest.domain.usuario;

public record DatosRegistroUsuario(
        String nombre,
        String email,
        String contrasena
) {
    public DatosRegistroUsuario(Usuario usuario) {
        this(
                usuario.getNombre(),
                usuario.getEmail(),
                usuario.getContrasena()
        );
    }
}
