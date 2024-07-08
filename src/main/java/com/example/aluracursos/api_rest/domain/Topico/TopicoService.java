package com.example.aluracursos.api_rest.domain.Topico;

import com.example.aluracursos.api_rest.domain.curso.Curso;
import com.example.aluracursos.api_rest.domain.curso.CursoRepository;
import com.example.aluracursos.api_rest.domain.usuario.Usuario;
import com.example.aluracursos.api_rest.domain.usuario.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicoService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private TopicoRepository topicoRepository;

    @Autowired
    private CursoRepository cursoRepository;


    public DatosRegistroTopico createTopico(DatosRegistroTopico datos) {
        Usuario autor = usuarioRepository.findByNombre(datos.nombreAutor()).orElseThrow(() -> new RuntimeException("autor no encontrado"));
        Curso curso = cursoRepository.findByNombre(datos.nombreCurso())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Topico topico = new Topico();
        topico.setTitulo(datos.titulo());
        topico.setMensaje(datos.mensaje());
        topico.setFechaCreacion(datos.fechaCreacion());
        topico.setAutor(autor);
        topico.setCurso(curso);
        topico.setStatus(true);


        Topico topicoGuardado = topicoRepository.save(topico);
        return new DatosRegistroTopico(topicoGuardado);
    }

    public Topico actualizarTopico(Long id, DatosActualizarTopico datos) {
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Topico no encontrado"));

        if (datos.titulo() != null) {
            topico.setTitulo(datos.titulo());
        }
        if (datos.mensaje() != null) {
            topico.setMensaje(datos.mensaje());
        }
        if (datos.fechaCreacion() != null) {
            topico.setFechaCreacion(datos.fechaCreacion());
        }

        if (datos.cursoId() != null) {
            Curso curso = cursoRepository.findById(datos.cursoId()).orElseThrow(() -> new RuntimeException("Curso no encontrado"));
            topico.setCurso(curso);
        }

        return topicoRepository.save(topico);
    }


    public DatosRegistroTopico topicoById(Long id){
        Topico topico = topicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Topico no encontrado"));
        return new DatosRegistroTopico(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getAutor().getNombre(), topico.getCurso().getNombre());
    }
    }

