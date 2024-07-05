package com.example.aluracursos.api_rest.domain.Topico;

import com.example.aluracursos.api_rest.domain.curso.Curso;
import com.example.aluracursos.api_rest.domain.curso.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;


    public DatosRegistroTopico createTopico(DatosRegistroTopico datos) {
        Curso curso = cursoRepository.findByNombre(datos.nombreCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setFechaCreacion(datos.fechaCreacion());
        topico.setCurso(curso);

        Topico topicoGuardado = topicoRepository.save(topico);
        return new DatosRegistroTopico(topicoGuardado);
    }
}
