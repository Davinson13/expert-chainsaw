/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.controller;

/**
 *
 * @author davin
 */
import com.educacion.dto.RegistroDTO;
import com.educacion.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping("/registro")
    public String registrarUsuario(@RequestBody RegistroDTO registroDTO) {
        return usuarioService.registrarUsuario(registroDTO);
    }
}
