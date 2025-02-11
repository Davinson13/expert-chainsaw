/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.service;

import com.educacion.dto.ForoDTO;
import com.educacion.model.Curso;
import com.educacion.model.Foro;
import com.educacion.model.Usuario;
import com.educacion.repository.CursoRepository;
import com.educacion.repository.ForoRepository;
import com.educacion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ForoService {

    @Autowired
    private ForoRepository foroRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Foro crearForo(ForoDTO foroDTO) {
        Usuario autor = usuarioRepository.findById(foroDTO.getAutorId())
                .orElseThrow(() -> new RuntimeException("Autor no encontrado"));

        Curso curso = cursoRepository.findById(foroDTO.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Foro foro = new Foro();
        foro.setContenido(foroDTO.getContenido());
        foro.setAutor(autor);
        foro.setCurso(curso);
        foro.setFechaCreacion(LocalDateTime.now());

        return foroRepository.save(foro);
    }

    public List<Foro> listarForosPorCurso(Long cursoId) {
        return foroRepository.findByCursoId(cursoId);
    }
}
