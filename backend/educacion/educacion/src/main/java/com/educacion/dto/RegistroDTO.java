/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.dto;

/**
 *
 * @author davin
 */
import lombok.Getter;
import lombok.Setter;
import com.educacion.model.Rol;

@Getter
@Setter
public class RegistroDTO {

    private String email;
    private String password;
    private Rol rol;
}
