package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.ValoracionesDTO;
import com.example.SwapShop.modelos.Valoraciones;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-12T13:55:38+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class ValoracionesMapperImpl implements ValoracionesMapper {

    @Override
    public Valoraciones toEntity(ValoracionesDTO valoraciones) {
        if ( valoraciones == null ) {
            return null;
        }

        Valoraciones valoraciones1 = new Valoraciones();

        if ( valoraciones.getId() != null ) {
            valoraciones1.setId( valoraciones.getId() );
        }
        if ( valoraciones.getPuntuacion() != null ) {
            valoraciones1.setPuntuacion( valoraciones.getPuntuacion() );
        }

        return valoraciones1;
    }

    @Override
    public ValoracionesDTO toDTO(Valoraciones valoraciones) {
        if ( valoraciones == null ) {
            return null;
        }

        ValoracionesDTO valoracionesDTO = new ValoracionesDTO();

        valoracionesDTO.setId( valoraciones.getId() );
        valoracionesDTO.setPuntuacion( valoraciones.getPuntuacion() );

        return valoracionesDTO;
    }
}
