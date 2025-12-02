package com.example.SwapShop.controladores;

import com.example.SwapShop.dto.EstadisticasUsuarioDTO;
import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.servicios.UsuarioService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/usuarios")
public class UsuarioController {
    private UsuarioService usuarioService;

    @PostMapping
    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        return usuarioService.crearUsuario(usuarioDTO);
    }

    @GetMapping("/{id}")
    public UsuarioDTO obtenerUsuarioId(Integer id) {
        return usuarioService.buscarUsuarioPorId(id);
    }

    @GetMapping("/estadisticas/usuarioActivo")
    public EstadisticasUsuarioDTO obtenerUsuarioActivo() {
        return usuarioService.obtenerUsuarioActivo();
    }
}
