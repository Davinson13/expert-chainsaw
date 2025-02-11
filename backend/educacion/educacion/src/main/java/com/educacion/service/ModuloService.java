/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.service;

import com.educacion.dto.ModuloDTO;
import com.educacion.model.Curso;
import com.educacion.model.Modulo;
import com.educacion.repository.CursoRepository;
import com.educacion.repository.ModuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModuloService {

    @Autowired
    private ModuloRepository moduloRepository;

    @Autowired
    private CursoRepository cursoRepository;

    public Modulo crearModulo(ModuloDTO moduloDTO) {
        Curso curso = cursoRepository.findById(moduloDTO.getCursoId())
                .orElseThrow(() -> new RuntimeException("Curso no encontrado"));

        Modulo modulo = new Modulo();
        modulo.setTitulo(moduloDTO.getTitulo());
        modulo.setDescripcion(moduloDTO.getDescripcion());
        modulo.setCurso(curso);

        return moduloRepository.save(modulo);
    }

    public List<Modulo> listarModulosPorCurso(Long cursoId) {
        return moduloRepository.findByCursoId(cursoId);
    }

    public Modulo actualizarModulo(Long id, ModuloDTO moduloDTO) {
        Modulo modulo = moduloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Módulo no encontrado"));

        modulo.setTitulo(moduloDTO.getTitulo());
        modulo.setDescripcion(moduloDTO.getDescripcion());

        return moduloRepository.save(modulo);
    }

    public void eliminarModulo(Long id) {
        moduloRepository.deleteById(id);
    }
}

