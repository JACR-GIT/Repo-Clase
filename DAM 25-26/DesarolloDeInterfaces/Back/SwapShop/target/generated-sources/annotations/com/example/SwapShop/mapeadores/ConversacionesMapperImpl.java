package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.ConversacionDTO;
import com.example.SwapShop.modelos.Conversaciones;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-12T13:55:38+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class ConversacionesMapperImpl implements ConversacionesMapper {

    @Override
    public Conversaciones toEntity(ConversacionDTO conversaciones) {
        if ( conversaciones == null ) {
            return null;
        }

        Conversaciones conversaciones1 = new Conversaciones();

        if ( conversaciones.getId() != null ) {
            conversaciones1.setId( conversaciones.getId() );
        }

        return conversaciones1;
    }

    @Override
    public ConversacionDTO toDTO(Conversaciones conversaciones) {
        if ( conversaciones == null ) {
            return null;
        }

        ConversacionDTO conversacionDTO = new ConversacionDTO();

        conversacionDTO.setId( conversaciones.getId() );

        return conversacionDTO;
    }
}
