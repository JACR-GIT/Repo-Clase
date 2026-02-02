package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.modelos.Usuario;
import java.sql.Date;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-12T13:55:38+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        if ( usuarioDTO == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        if ( usuarioDTO.getId() != null ) {
            usuario.setId( usuarioDTO.getId() );
        }
        usuario.setNombre( usuarioDTO.getNombre() );
        usuario.setApellido1( usuarioDTO.getApellido1() );
        usuario.setApellido2( usuarioDTO.getApellido2() );
        usuario.setCorreo( usuarioDTO.getCorreo() );
        usuario.setContrasena( usuarioDTO.getContrasena() );
        usuario.setFecha_nac( usuarioDTO.getFecha_nac() );

        return usuario;
    }

    @Override
    public UsuarioDTO toDTO(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioDTO usuarioDTO = new UsuarioDTO();

        usuarioDTO.setId( usuario.getId() );
        usuarioDTO.setNombre( usuario.getNombre() );
        usuarioDTO.setApellido1( usuario.getApellido1() );
        usuarioDTO.setApellido2( usuario.getApellido2() );
        usuarioDTO.setCorreo( usuario.getCorreo() );
        usuarioDTO.setContrasena( usuario.getContrasena() );
        if ( usuario.getFecha_nac() != null ) {
            usuarioDTO.setFecha_nac( new Date( usuario.getFecha_nac().getTime() ) );
        }

        return usuarioDTO;
    }
}
