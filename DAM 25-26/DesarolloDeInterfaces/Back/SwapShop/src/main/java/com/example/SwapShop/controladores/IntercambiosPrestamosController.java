package com.example.SwapShop.controladores;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.servicios.IntercambiosPrestamosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/intercambios-prestamos")
public class IntercambiosPrestamosController {

    private IntercambiosPrestamosService intercambiosPrestamosService;

    @PostMapping
    public IntercambiosPrestamosDTO crearIntercambioPrestamo(IntercambiosPrestamosDTO intercambiosPrestamosDTO) {
        return intercambiosPrestamosService.crearIntercambioPrestamo(intercambiosPrestamosDTO);
    }

    @PatchMapping("/{id}")
    public IntercambiosPrestamosDTO actualizarEstadoIntercambioPrestamo(IntercambiosPrestamosDTO intercambiosPrestamosDTO) {
        return intercambiosPrestamosService.cambiarEstado(intercambiosPrestamosDTO);
    }
}
