package com.example.aluracursos.api_rest.domain.respuesta;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RespuestaRepository extends JpaRepository<Respuesta,Long> {
    Page<Respuesta> findByTopicoId(Long topicoId, Pageable pageable);
}
