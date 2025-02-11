/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.controller;

import com.educacion.dto.CursoDTO;
import com.educacion.model.Curso;
import com.educacion.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('PROFESOR')")
    public Curso crearCurso(@RequestBody CursoDTO cursoDTO) {
        return cursoService.crearCurso(cursoDTO);
    }

    @GetMapping
    public List<Curso> listarCursos() {
        return cursoService.listarCursos();
    }

    @GetMapping("/{id}")
    public Curso obtenerCurso(@PathVariable Long id) {
        return cursoService.obtenerCurso(id);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('PROFESOR')")
    public Curso actualizarCurso(@PathVariable Long id, @RequestBody CursoDTO cursoDTO) {
        return cursoService.actualizarCurso(id, cursoDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
    }
}
