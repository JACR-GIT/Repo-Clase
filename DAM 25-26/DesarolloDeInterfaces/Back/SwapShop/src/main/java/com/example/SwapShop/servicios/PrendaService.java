package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.mapeadores.PrendasMapper;
import com.example.SwapShop.modelos.Prendas;
import com.example.SwapShop.repositorios.IPrendasRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PrendaService {

    private IPrendasRepository prendasRepository;
    private PrendasMapper prendasMapper;

    public PrendasDTO crearPrenda(PrendasDTO prendasDTO) {
        Prendas prenda = prendasMapper.toEntity(prendasDTO);
        Prendas prendaGuardada = prendasRepository.save(prenda);
        return prendasMapper.toDTO(prendaGuardada);
    }

    public PrendasDTO buscarPrendaPorTalla (PrendasDTO prendasDTO) {
        Prendas prenda = prendasMapper.toEntity(prendasDTO);
        Prendas prendaBuscada = prendasRepository.findByTalla(prenda.getTalla());
        return prendasMapper.toDTO(prendaBuscada);
    }

    public PrendasDTO modificarPrendaPorId (PrendasDTO prendasDTO) {
        Integer id = prendasDTO.getId();
        if (id == null) {
            throw new IllegalArgumentException("El id de la prenda es requerido para modificar.");
        }

        Prendas existente = prendasRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Prenda no encontrada con id: " + id));

        Prendas prendaActualizada = prendasMapper.toEntity(prendasDTO);
        Prendas prendaGuardada = prendasRepository.save(prendaActualizada);
        return prendasMapper.toDTO(prendaGuardada);
    }


}
