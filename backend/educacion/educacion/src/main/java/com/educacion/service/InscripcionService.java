/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.service;

import com.educacion.dto.InscripcionDTO;
import com.educacion.model.Curso;
import com.educacion.model.Inscripcion;
import com.educacion.model.Usuario;
import com.educacion.repository.CursoRepository;
import com.educacion.repository.InscripcionRepository;
import com.educacion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscripcionService {

    @Autowired
    private InscripcionRepository inscripcionRepository;

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Inscripcion inscribirEstudiante(InscripcionDTO inscripcionDTO) {
        Curso curso = cursoRepository.findById(inscripcionDTO.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Usuario estudiante = usuarioRepository.findById(inscripcionDTO.getEstudianteId())
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        if (inscripcionRepository.findByCursoAndEstudiante(curso, estudiante).isPresent()) {
            throw new RuntimeException("El estudiante ya está inscrito en este curso");
        }

        Inscripcion inscripcion = new Inscripcion();
        inscripcion.setCurso(curso);
        inscripcion.setEstudiante(estudiante);

        return inscripcionRepository.save(inscripcion);
    }

    public void desinscribirEstudiante(Long cursoId, Long estudianteId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Usuario estudiante = usuarioRepository.findById(estudianteId)
                .orElseThrow(() -> new RuntimeException("Estudiante no encontrado"));

        Inscripcion inscripcion = inscripcionRepository.findByCursoAndEstudiante(curso, estudiante)
                .orElseThrow(() -> new RuntimeException("El estudiante no está inscrito en este curso"));

        inscripcionRepository.delete(inscripcion);
    }

    public List<Inscripcion> listarInscripcionesPorCurso(Long cursoId) {
        Curso curso = cursoRepository.findById(cursoId)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        return inscripcionRepository.findByCurso(curso);
    }
}
