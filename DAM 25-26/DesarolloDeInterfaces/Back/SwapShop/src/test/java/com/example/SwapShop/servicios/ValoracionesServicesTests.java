package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.ValoracionesDTO;
import com.example.SwapShop.mapeadores.ValoracionesMapper;
import com.example.SwapShop.modelos.Valoraciones;
import com.example.SwapShop.repositorios.IValoracionesRepositoryTests;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValoracionesServicesTests {

    private IValoracionesRepositoryTests valoracionesRepository;
    private ValoracionesMapper valoracionesMapper;

    public ValoracionesDTO crearValoracion(ValoracionesDTO valoracionesDTO) {
        Valoraciones valoracion = valoracionesMapper.toEntity(valoracionesDTO);
        Valoraciones valoracionGuardada = valoracionesRepository.save(valoracion);
        return valoracionesMapper.toDTO(valoracionGuardada);
    }
}
