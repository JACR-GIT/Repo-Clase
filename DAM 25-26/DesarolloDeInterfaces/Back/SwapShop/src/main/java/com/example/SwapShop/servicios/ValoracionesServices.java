package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.dto.ValoracionesDTO;
import com.example.SwapShop.mapeadores.UsuarioMapper;
import com.example.SwapShop.mapeadores.ValoracionesMapper;
import com.example.SwapShop.modelos.Usuario;
import com.example.SwapShop.modelos.Valoraciones;
import com.example.SwapShop.repositorios.IValoracionesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ValoracionesServices {

    private final UsuarioMapper usuarioMapper;
    private IValoracionesRepository valoracionesRepository;
    private ValoracionesMapper valoracionesMapper;
    private UsuarioService usarioService;

    public ValoracionesDTO crearValoracion(Integer id_valorado, ValoracionesDTO valoracionesDTO) {
        if (valoracionesDTO == null || valoracionesDTO.getPuntuacion() == null || valoracionesDTO.getValorador() == null
                || valoracionesDTO.getId() == null || id_valorado == null) {
            throw new IllegalArgumentException("Ha salido un error: Los datos de la valoración no pueden ser nulos");
        }

        Valoraciones valoracion = valoracionesMapper.toEntity(valoracionesDTO);

        UsuarioDTO user = usarioService.buscarUsuarioPorId(id_valorado);
        valoracion.setValorado(usuarioMapper.toEntity(user));
        Valoraciones valoracionGuardada = valoracionesRepository.save(valoracion);
        return valoracionesMapper.toDTO(valoracionGuardada);
    }
}
