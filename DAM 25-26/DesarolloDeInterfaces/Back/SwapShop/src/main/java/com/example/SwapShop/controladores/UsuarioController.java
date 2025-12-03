package com.example.SwapShop.controladores;

import com.example.SwapShop.dto.EstadisticasUsuarioDTO;
import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.dto.ValoracionesDTO;
import com.example.SwapShop.servicios.UsuarioService;
import com.example.SwapShop.servicios.ValoracionesServices;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
    @AllArgsConstructor
    @RequestMapping("/usuarios")
    public class UsuarioController {
        private UsuarioService usuarioService;
        private ValoracionesServices valoracionesServices;

        @PostMapping
        public UsuarioDTO crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {
            return usuarioService.crearUsuario(usuarioDTO);
        }

        @PostMapping("/{id}/valoraciones")
        public ValoracionesDTO crearValoracionUsuario(ValoracionesDTO valoracionesDTO) {
            return valoracionesServices.crearValoracion(valoracionesDTO);
        }

        @GetMapping("/{id}")
        public UsuarioDTO obtenerUsuarioId(@PathVariable Integer id) {
            return usuarioService.buscarUsuarioPorId(id);
        }

        @GetMapping("/estadisticas/usuarioActivo")
        public EstadisticasUsuarioDTO usuarioConMasIntercambios() {
            return usuarioService.usuarioConMasIntercambios();
        }

        @GetMapping("/all")
        public Iterable<UsuarioDTO> obtenerTodosLosUsuarios() {
            return usuarioService.obtenerTodosLosUsuarios();
        }


    }
