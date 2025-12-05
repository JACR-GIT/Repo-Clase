package com.example.SwapShop.controladores;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.modelos.EstadoIntercambio;
import com.example.SwapShop.servicios.IntercambiosPrestamosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/intercambios-prestamos")
public class IntercambiosPrestamosController {

    private IntercambiosPrestamosService intercambiosPrestamosService;

    @PostMapping
    public IntercambiosPrestamosDTO crearIntercambioPrestamo(@RequestBody IntercambiosPrestamosDTO intercambiosPrestamosDTO) {
        return intercambiosPrestamosService.crearIntercambioPrestamo(intercambiosPrestamosDTO);
    }

    @PatchMapping("/{id}")
    public IntercambiosPrestamosDTO actualizarEstadoIntercambioPrestamo(@PathVariable Integer id, @RequestParam("estado") EstadoIntercambio estadoIntercambio) {
        return intercambiosPrestamosService.cambiarEstado(id, estadoIntercambio);
    }
}
