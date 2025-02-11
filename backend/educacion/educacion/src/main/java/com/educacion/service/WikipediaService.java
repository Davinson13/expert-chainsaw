/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.educacion.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class WikipediaService {

    private final String WIKIPEDIA_API_URL = "https://en.wikipedia.org/api/rest_v1/page/summary/";

    public String obtenerResumen(String tema) {
        RestTemplate restTemplate = new RestTemplate();
        String url = WIKIPEDIA_API_URL + tema.replace(" ", "_");

        Map<String, Object> respuesta = restTemplate.getForObject(url, Map.class);
        return respuesta != null ? (String) respuesta.get("extract") : "No se encontró información.";
    }
}

