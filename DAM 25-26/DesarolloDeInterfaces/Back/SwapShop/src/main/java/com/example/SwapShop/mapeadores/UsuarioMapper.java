package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.modelos.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity (UsuarioDTO usuarioDTO);

    UsuarioDTO toDTO (Usuario usuario);
}
