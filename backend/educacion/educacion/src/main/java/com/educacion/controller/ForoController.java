/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.controller;

import com.educacion.dto.ForoDTO;
import com.educacion.model.Foro;
import com.educacion.service.ForoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/foros")
public class ForoController {

    @Autowired
    private ForoService foroService;

    @PostMapping
    @PreAuthorize("hasRole('ESTUDIANTE') or hasRole('PROFESOR')")
    public Foro crearForo(@RequestBody ForoDTO foroDTO) {
        return foroService.crearForo(foroDTO);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Foro> listarForosPorCurso(@PathVariable Long cursoId) {
        return foroService.listarForosPorCurso(cursoId);
    }
}

