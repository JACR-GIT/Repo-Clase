package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.MensajesDTO;
import com.example.SwapShop.modelos.Mensajes;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-12T13:55:38+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class MensajesMapperImpl implements MensajesMapper {

    @Override
    public Mensajes toEntity(MensajesDTO mensajes) {
        if ( mensajes == null ) {
            return null;
        }

        Mensajes mensajes1 = new Mensajes();

        if ( mensajes.getId() != null ) {
            mensajes1.setId( mensajes.getId() );
        }
        mensajes1.setContenido( mensajes.getContenido() );

        return mensajes1;
    }

    @Override
    public MensajesDTO toDTO(Mensajes mensajes) {
        if ( mensajes == null ) {
            return null;
        }

        MensajesDTO mensajesDTO = new MensajesDTO();

        mensajesDTO.setId( mensajes.getId() );
        mensajesDTO.setContenido( mensajes.getContenido() );

        return mensajesDTO;
    }
}
