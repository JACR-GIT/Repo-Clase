package com.example.SwapShop.controladores;

import com.example.SwapShop.dto.EstadisticasPrendaDTO;
import com.example.SwapShop.dto.EstadisticasUsuarioDTO;
import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.servicios.PrendaService;
import com.example.SwapShop.servicios.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/estadisticas")
public class EstadisticasController {

    private PrendaService prendasService;
    private UsuarioService usuarioService;

    @GetMapping("/usuarioActivo")
    public EstadisticasUsuarioDTO usuarioConMasIntercambios() {
        return usuarioService.usuarioConMasIntercambios();
    }
    @GetMapping("/prendaPopular")
    public List<EstadisticasPrendaDTO> prendaPopular() {
        return prendasService.top5PrendasMasIntercambiadasAceptadas();
    }
}
