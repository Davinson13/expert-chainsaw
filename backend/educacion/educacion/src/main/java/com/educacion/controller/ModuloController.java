/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.controller;

import com.educacion.dto.ModuloDTO;
import com.educacion.model.Modulo;
import com.educacion.service.ModuloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/modulos")
public class ModuloController {

    @Autowired
    private ModuloService moduloService;

    @PostMapping
    @PreAuthorize("hasRole('PROFESOR')")
    public Modulo crearModulo(@RequestBody ModuloDTO moduloDTO) {
        return moduloService.crearModulo(moduloDTO);
    }

    @GetMapping("/curso/{cursoId}")
    public List<Modulo> listarModulosPorCurso(@PathVariable Long cursoId) {
        return moduloService.listarModulosPorCurso(cursoId);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('PROFESOR')")
    public Modulo actualizarModulo(@PathVariable Long id, @RequestBody ModuloDTO moduloDTO) {
        return moduloService.actualizarModulo(id, moduloDTO);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public void eliminarModulo(@PathVariable Long id) {
        moduloService.eliminarModulo(id);
    }
}

