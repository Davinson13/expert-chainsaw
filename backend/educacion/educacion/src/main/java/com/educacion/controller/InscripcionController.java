/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.controller;

import com.educacion.dto.InscripcionDTO;
import com.educacion.model.Inscripcion;
import com.educacion.service.InscripcionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inscripciones")
public class InscripcionController {

    @Autowired
    private InscripcionService inscripcionService;

    @PostMapping
    @PreAuthorize("hasRole('ESTUDIANTE')")
    public Inscripcion inscribirEstudiante(@RequestBody InscripcionDTO inscripcionDTO) {
        return inscripcionService.inscribirEstudiante(inscripcionDTO);
    }

    @DeleteMapping("/{cursoId}/{estudianteId}")
    @PreAuthorize("hasRole('ESTUDIANTE')")
    public void desinscribirEstudiante(@PathVariable Long cursoId, @PathVariable Long estudianteId) {
        inscripcionService.desinscribirEstudiante(cursoId, estudianteId);
    }

    @GetMapping("/curso/{cursoId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('PROFESOR')")
    public List<Inscripcion> listarInscripcionesPorCurso(@PathVariable Long cursoId) {
        return inscripcionService.listarInscripcionesPorCurso(cursoId);
    }
}
