package com.example.aluracursos.api_rest.domain.respuesta;

import com.example.aluracursos.api_rest.domain.Topico.Topico;
import com.example.aluracursos.api_rest.domain.Topico.TopicoRepository;
import com.example.aluracursos.api_rest.domain.usuario.Usuario;
import com.example.aluracursos.api_rest.domain.usuario.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class RespuestaService {
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    TopicoRepository topicoRepository;
    @Autowired
    RespuestaRepository respuestaRepository;


    public DatosRespuesta crearRespuesta(DatosRespuesta datosRespuesta){
        Usuario autor = usuarioRepository.findByNombre(datosRespuesta.autor()).orElseThrow(() -> new RuntimeException("autor no encontrado"));
       Topico topico = topicoRepository.getReferenceById(datosRespuesta.idTopico());

        Respuesta respuesta = new Respuesta();
        respuesta.setMensaje(datosRespuesta.mensaje());
        respuesta.setFechaCreacion(datosRespuesta.fechaCreacion());
        respuesta.setAutor(autor);
        respuesta.setTopico(topico);

        Respuesta respuestaGuardada = respuestaRepository.save(respuesta);
        return new DatosRespuesta(respuestaGuardada);
    }

    public Page<Respuesta> getRespuestasPorTopico(Long topicoId, Pageable pageable) {
        return respuestaRepository.findByTopicoId(topicoId, pageable);
    }

    public Respuesta actualizarRespuesta(DatosActualizarRespuesta datos) {
        Respuesta respuesta = respuestaRepository.findById(datos.id())
                .orElseThrow(() -> new RuntimeException("Respuesta no encontrada"));

        respuesta.setMensaje(datos.mensaje());
        respuesta.setFechaCreacion(datos.fechaCreacion());
        return respuestaRepository.save(respuesta);
    }
    public void eliminarRespuesta(Long id) {
        respuestaRepository.deleteById(id);
    }
}
