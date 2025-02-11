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

import java.util.List;

@Getter
@Setter
public class CursoDTO {

    private String nombre;
    private Long profesorId;
    private List<Long> estudianteIds;
}
