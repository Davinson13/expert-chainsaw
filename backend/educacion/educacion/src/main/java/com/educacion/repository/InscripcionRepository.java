/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.repository;

import com.educacion.model.Curso;
import com.educacion.model.Inscripcion;
import com.educacion.model.Usuario;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davin
 */
@Repository
public interface InscripcionRepository extends JpaRepository<Inscripcion, Long> {
    List<Inscripcion> findByCurso(Curso curso);
    List<Inscripcion> findByEstudiante(Usuario estudiante);
    Optional<Inscripcion> findByCursoAndEstudiante(Curso curso, Usuario estudiante);
}