/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.service;

/**
 *
 * @author davin
 */
import com.educacion.dto.RegistroDTO;
import com.educacion.model.Usuario;
import com.educacion.repository.UsuarioRepository;
import com.educacion.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public String registrarUsuario(RegistroDTO registroDTO) {
        if (usuarioRepository.findByEmail(registroDTO.getEmail()).isPresent()) {
            throw new RuntimeException("El correo ya está registrado");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail(registroDTO.getEmail());
        usuario.setPassword(passwordEncoder.encode(registroDTO.getPassword()));
        usuario.setRol(registroDTO.getRol());

        usuarioRepository.save(usuario);

        return jwtUtil.generateToken(usuario.getEmail());
    }
}
