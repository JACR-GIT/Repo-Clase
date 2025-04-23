package com.proyectojpa.controladores;

import com.proyectojpa.modelos.Centro;
import com.proyectojpa.servicios.CentroService;

import java.util.List;

public class CentroController {

    private final CentroService centroService;

    public CentroController() {
        this.centroService = new CentroService();
    }

    public CentroController(CentroService centroService) {
        this.centroService = centroService;
    }

    public void addCentro(Centro centro) {
        centroService.addCentro(centro);
    }

    public List<Centro> getAllCentros() {
        return centroService.getAllCentros();
    }

    public Centro getCentroByName(String name) {
        return centroService.getCentroByName(name);
    }

    public Centro getCentroById(Long id) {
        return centroService.getCentroById(id);
    }
}

