package com.example.aluracursos.api_rest.domain.usuario;

import com.example.aluracursos.api_rest.domain.curso.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    UserDetails findByEmail(String username);
    Optional<Usuario> findByNombre(String nombre);
}
