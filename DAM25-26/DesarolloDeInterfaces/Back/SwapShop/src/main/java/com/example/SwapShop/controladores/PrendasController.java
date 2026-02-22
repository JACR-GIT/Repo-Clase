package com.example.SwapShop.controladores;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.servicios.PrendaService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/prendas")  // Cambiado a /api/prendas para el frontend // Evita errores CORS
public class PrendasController {

    private final PrendaService prendasService;

    @PostMapping
    public PrendasDTO crearPrenda(@Valid @RequestBody PrendasDTO prendasDTO) {
        return prendasService.crearPrenda(prendasDTO);
    }

    @GetMapping("/dueno/{idDueno}")  // NUEVO: Lista prendas por dueño (para "Mis Prendas")
    public List<PrendasDTO> obtenerPrendasPorDueno(@PathVariable Integer idDueno) {
        return prendasService.buscarPrendasPorDueno(idDueno);  // Implementa este en el servicio
    }

    @PutMapping("/{id}")
    public PrendasDTO actualizarPrendaPorId(@PathVariable Integer id, @Valid @RequestBody PrendasDTO prendasDTO) {
        return prendasService.modificarPrendaPorId(id, prendasDTO);
    }

    @DeleteMapping("/{id}")  // NUEVO: Eliminar prenda
    public ResponseEntity<Void> eliminarPrenda(@PathVariable Integer id) {
        prendasService.eliminarPrendaPorId(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public List<PrendasDTO> listarPrendas(@RequestParam String talla) {
        return prendasService.buscarPrendaPorTalla(talla);
    }

    @GetMapping("/disponibles")
    public List<PrendasDTO> obtenerTodasDisponibles() {
        return prendasService.findAllPrendasWhenDisponible();
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "¡El controlador de prendas con servicio funciona!";
    }
}