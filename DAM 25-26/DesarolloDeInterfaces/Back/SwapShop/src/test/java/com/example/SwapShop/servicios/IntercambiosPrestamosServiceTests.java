package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.mapeadores.IntercambiosPrestamosMapper;
import com.example.SwapShop.modelos.IntercambiosPrestamosTests;
import com.example.SwapShop.repositorios.IIntercambiosPrestamosRepositoryTests;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IntercambiosPrestamosServiceTests {

    private IIntercambiosPrestamosRepositoryTests intercambiosPrestamosRepository;
    private IntercambiosPrestamosMapper intercambiosPrestamosMapper;

    public IntercambiosPrestamosDTO crearIntercambioPrestamo(IntercambiosPrestamosDTO intercambiosPrestamosDTO) {
        IntercambiosPrestamosTests intercambioPrestamo = intercambiosPrestamosMapper.toEntity(intercambiosPrestamosDTO);
        IntercambiosPrestamosTests intercambioPrestamoGuardado = intercambiosPrestamosRepository.save(intercambioPrestamo);
        return intercambiosPrestamosMapper.toDTO(intercambioPrestamoGuardado);
    }

    public IntercambiosPrestamosDTO cambiarEstado (IntercambiosPrestamosDTO intercambiosPrestamosDTO) {
        Integer id = intercambiosPrestamosDTO.getId();
        if (id == null) {
            throw new IllegalArgumentException("El id del intercambio o préstamo es requerido para modificar.");
        }

        IntercambiosPrestamosTests existente = intercambiosPrestamosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Intercambio o préstamo no encontrado con id: " + id));

        existente.setEstado(intercambiosPrestamosDTO.getEstado());
        IntercambiosPrestamosTests intercambioPrestamoGuardado = intercambiosPrestamosRepository.save(existente);
        return intercambiosPrestamosMapper.toDTO(intercambioPrestamoGuardado);
    }


}
