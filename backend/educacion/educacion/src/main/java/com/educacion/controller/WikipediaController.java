/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.controller;

import com.educacion.service.WikipediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contenido")
public class WikipediaController {

    @Autowired
    private WikipediaService wikipediaService;

    @GetMapping("/wikipedia/{tema}")
    public String obtenerResumen(@PathVariable String tema) {
        return wikipediaService.obtenerResumen(tema);
    }
}
