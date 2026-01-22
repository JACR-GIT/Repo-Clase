package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.mapeadores.IntercambiosPrestamosMapper;
import com.example.SwapShop.modelos.EstadoIntercambio;
import com.example.SwapShop.modelos.IntercambiosPrestamos;
import com.example.SwapShop.repositorios.IIntercambiosPrestamosRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class IntercambiosPrestamosService {

    private IIntercambiosPrestamosRepository intercambiosPrestamosRepository;
    private IntercambiosPrestamosMapper intercambiosPrestamosMapper;

    public IntercambiosPrestamosDTO crearIntercambioPrestamo(IntercambiosPrestamosDTO intercambiosPrestamosDTO) {
        if (intercambiosPrestamosDTO == null) {
            throw new IllegalArgumentException("El intercambio/préstamo no puede ser nulo");
        }
        if (intercambiosPrestamosDTO.getId_prenda() == null) {
            throw new IllegalArgumentException("El ID de la prenda es obligatorio");
        }
        if (intercambiosPrestamosDTO.getId_solicitante() == null) {
            throw new IllegalArgumentException("El ID del solicitante es obligatorio");
        }
        if (intercambiosPrestamosDTO.getId_dueno() == null) {
            throw new IllegalArgumentException("El ID del dueño es obligatorio");
        }
        if (intercambiosPrestamosDTO.getTipo() == null) {
            throw new IllegalArgumentException("El tipo de intercambio es obligatorio");
        }
        if (intercambiosPrestamosDTO.getEstado() == null) {
            throw new IllegalArgumentException("El estado del intercambio es obligatorio");
        }
        if (intercambiosPrestamosDTO.getFecha_inicio() == null) {
            throw new IllegalArgumentException("La fecha de inicio es obligatoria");
        }

        IntercambiosPrestamos intercambioPrestamo = intercambiosPrestamosMapper.toEntity(intercambiosPrestamosDTO);
        IntercambiosPrestamos intercambioPrestamoGuardado = intercambiosPrestamosRepository.save(intercambioPrestamo);
        return intercambiosPrestamosMapper.toDTO(intercambioPrestamoGuardado);
    }

    public IntercambiosPrestamosDTO modificarIntercambioPrestamo(Integer id, IntercambiosPrestamosDTO intercambiosPrestamosDTO) {
        IntercambiosPrestamos existente = intercambiosPrestamosRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Intercambio o préstamo no encontrado con id: " + id));

        intercambiosPrestamosMapper.updateEntityFromDto(intercambiosPrestamosDTO, existente);

        IntercambiosPrestamos intercambioPrestamoActualizado = intercambiosPrestamosRepository.save(existente);
        return intercambiosPrestamosMapper.toDTO(intercambioPrestamoActualizado);
    }

    public IntercambiosPrestamosDTO cambiarEstado (Integer id, EstadoIntercambio estadoIntercambio) {
        if (id == null) {
            throw new IllegalArgumentException("El id del intercambio o préstamo es requerido para modificar.");
        }
        if (estadoIntercambio == null) {
            throw new IllegalArgumentException("El nuevo estado no puede ser null");
        }
        IntercambiosPrestamos existente = intercambiosPrestamosRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Intercambio o préstamo no encontrado con id: " + id));

        existente.setEstado(estadoIntercambio);
        IntercambiosPrestamos intercambioPrestamoGuardado = intercambiosPrestamosRepository.save(existente);
        return intercambiosPrestamosMapper.toDTO(intercambioPrestamoGuardado);
    }
}
