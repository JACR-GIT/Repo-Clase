package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.mapeadores.IntercambiosPrestamosMapper;
import com.example.SwapShop.modelos.IntercambiosPrestamos;
import com.example.SwapShop.repositorios.IIntercambiosPrestamosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class IntercambiosPrestamosService {

    private IIntercambiosPrestamosRepository intercambiosPrestamosRepository;
    private IntercambiosPrestamosMapper intercambiosPrestamosMapper;

    public IntercambiosPrestamosDTO crearIntercambioPrestamo(IntercambiosPrestamosDTO intercambiosPrestamosDTO) {
        IntercambiosPrestamos intercambioPrestamo = intercambiosPrestamosMapper.toEntity(intercambiosPrestamosDTO);
        IntercambiosPrestamos intercambioPrestamoGuardado = intercambiosPrestamosRepository.save(intercambioPrestamo);
        return intercambiosPrestamosMapper.toDTO(intercambioPrestamoGuardado);
    }

    public IntercambiosPrestamosDTO cambiarEstado (IntercambiosPrestamosDTO intercambiosPrestamosDTO) {
        Integer id = intercambiosPrestamosDTO.getId();
        if (id == null) {
            throw new IllegalArgumentException("El id del intercambio o préstamo es requerido para modificar.");
        }

        IntercambiosPrestamos existente = intercambiosPrestamosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Intercambio o préstamo no encontrado con id: " + id));

        existente.setEstado(intercambiosPrestamosDTO.getEstado());
        IntercambiosPrestamos intercambioPrestamoGuardado = intercambiosPrestamosRepository.save(existente);
        return intercambiosPrestamosMapper.toDTO(intercambioPrestamoGuardado);
    }

    
}
