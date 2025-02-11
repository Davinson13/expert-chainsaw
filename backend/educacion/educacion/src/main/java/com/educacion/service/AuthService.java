/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.service;

import com.educacion.dto.LoginRequestDTO;
import com.educacion.dto.AuthResponseDTO;
import com.educacion.model.Usuario;
import com.educacion.repository.UsuarioRepository;
import com.educacion.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    public AuthResponseDTO login(LoginRequestDTO loginRequest) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByEmail(loginRequest.getEmail());

        if (usuarioOpt.isEmpty() || !passwordEncoder.matches(loginRequest.getPassword(), usuarioOpt.get().getPassword())) {
            throw new RuntimeException("Credenciales incorrectas");
        }

        String token = jwtUtil.generateToken(usuarioOpt.get().getEmail());

        return new AuthResponseDTO(token, usuarioOpt.get().getRol().name());
    }
}

