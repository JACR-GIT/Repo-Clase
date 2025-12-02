package com.example.SwapShop.controladores;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.servicios.PrendaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/prendas")
public class PrendasController {

    private PrendaService prendasService;
    @PostMapping
    public PrendasDTO crearPrenda(PrendasDTO prendasDTO) {
        return prendasService.crearPrenda(prendasDTO);
    }
}
