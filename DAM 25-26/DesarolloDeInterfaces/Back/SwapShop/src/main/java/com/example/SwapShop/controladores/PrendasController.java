package com.example.SwapShop.controladores;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.servicios.PrendaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/prendas")
public class PrendasController {

    private PrendaService prendasService;

    @PostMapping
    public PrendasDTO crearPrenda(PrendasDTO prendasDTO) {
        return prendasService.crearPrenda(prendasDTO);
    }

    @GetMapping
    public List<PrendasDTO> listarPrendas(@RequestParam String talla) {
        return prendasService.buscarPrendaPorTalla(talla);}

    @PutMapping("/{id}")
    public PrendasDTO actualizarPrendaPorId (PrendasDTO prendasDTO) {return prendasService.modificarPrendaPorId(prendasDTO);}
}
