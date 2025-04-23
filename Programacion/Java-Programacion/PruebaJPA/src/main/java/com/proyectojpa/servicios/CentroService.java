package com.proyectojpa.servicios;

import com.proyectojpa.modelos.Centro;
import com.proyectojpa.repositorios.CentroRepository;
import jakarta.transaction.Transactional;
import java.util.List;

public class CentroService {

    private final CentroRepository centroRepository;

    public CentroService() {
        this.centroRepository = new CentroRepository();
    }

    public CentroService(CentroRepository centroRepository) {
        this.centroRepository = centroRepository;
    }

    @Transactional
    public void addCentro(Centro centro) {
        centroRepository.save(centro);
    }

    public List<Centro> getAllCentros() {
        return centroRepository.getAll();
    }

    public Centro getCentroByName(String nombre) {
        return centroRepository.getByName(nombre);
    }

    public Centro getCentroById(Long id) {
        return centroRepository.getById(id);
    }
}

