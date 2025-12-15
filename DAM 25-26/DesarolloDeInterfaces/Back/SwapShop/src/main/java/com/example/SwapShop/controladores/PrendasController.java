package com.example.SwapShop.controladores;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.servicios.PrendaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/prendas")
public class PrendasController {

    private final PrendaService prendasService;

    @PostMapping
    public PrendasDTO crearPrenda(@Valid @RequestBody PrendasDTO prendasDTO) {
        return prendasService.crearPrenda(prendasDTO);
    }

    @GetMapping
    public List<PrendasDTO> listarPrendas(@RequestParam String talla) {
        return prendasService.buscarPrendaPorTalla(talla);
    }

    @PutMapping("/{id}")
    public PrendasDTO actualizarPrendaPorId(@PathVariable Integer id, @Valid @RequestBody PrendasDTO prendasDTO) {
        return prendasService.modificarPrendaPorId(id, prendasDTO);
    }

    @GetMapping("/disponibles")
    public List<PrendasDTO> obtenerPrendasDisponibles() {
        return prendasService.findAllPrendasWhenDisponible();
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "¡El controlador de prendas con servicio funciona!";
    }
}
