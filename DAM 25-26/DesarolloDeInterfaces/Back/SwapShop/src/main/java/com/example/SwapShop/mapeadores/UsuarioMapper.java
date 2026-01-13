package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.modelos.Usuario;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity (UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO (Usuario usuario);

    List<UsuarioDTO> toDTO (List<Usuario> usuarios);

    List<Usuario> toEntity (List<UsuarioDTO> usuarioDTOS);
}
