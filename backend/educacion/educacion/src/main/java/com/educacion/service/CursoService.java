/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.service;

import com.educacion.dto.CursoDTO;
import com.educacion.model.Curso;
import com.educacion.model.Usuario;
import com.educacion.repository.CursoRepository;
import com.educacion.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Curso crearCurso(CursoDTO cursoDTO) {
        Usuario profesor = usuarioRepository.findById(cursoDTO.getProfesorId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        List<Usuario> estudiantes = usuarioRepository.findAllById(cursoDTO.getEstudianteIds());

        Curso curso = new Curso();
        curso.setNombre(cursoDTO.getNombre());
        curso.setProfesor(profesor);
        curso.setEstudiantes(estudiantes);

        return cursoRepository.save(curso);
    }

    public List<Curso> listarCursos() {
        return cursoRepository.findAll();
    }

    public Curso obtenerCurso(Long id) {
        return cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));
    }

    public Curso actualizarCurso(Long id, CursoDTO cursoDTO) {
        Curso curso = cursoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Usuario profesor = usuarioRepository.findById(cursoDTO.getProfesorId())
                .orElseThrow(() -> new RuntimeException("Profesor no encontrado"));

        List<Usuario> estudiantes = usuarioRepository.findAllById(cursoDTO.getEstudianteIds());

        curso.setNombre(cursoDTO.getNombre());
        curso.setProfesor(profesor);
        curso.setEstudiantes(estudiantes);

        return cursoRepository.save(curso);
    }

    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }
}
