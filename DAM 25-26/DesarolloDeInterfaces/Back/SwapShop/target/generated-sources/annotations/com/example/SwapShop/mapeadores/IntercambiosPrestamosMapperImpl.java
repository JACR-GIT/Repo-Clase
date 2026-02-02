package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.modelos.IntercambiosPrestamos;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-12T13:55:38+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class IntercambiosPrestamosMapperImpl implements IntercambiosPrestamosMapper {

    @Override
    public IntercambiosPrestamosDTO toDTO(IntercambiosPrestamos intercambios) {
        if ( intercambios == null ) {
            return null;
        }

        IntercambiosPrestamosDTO intercambiosPrestamosDTO = new IntercambiosPrestamosDTO();

        intercambiosPrestamosDTO.setId( intercambios.getId() );
        intercambiosPrestamosDTO.setTipo( intercambios.getTipo() );
        intercambiosPrestamosDTO.setEstado( intercambios.getEstado() );

        return intercambiosPrestamosDTO;
    }

    @Override
    public IntercambiosPrestamos toEntity(IntercambiosPrestamosDTO intercambiosDTO) {
        if ( intercambiosDTO == null ) {
            return null;
        }

        IntercambiosPrestamos intercambiosPrestamos = new IntercambiosPrestamos();

        if ( intercambiosDTO.getId() != null ) {
            intercambiosPrestamos.setId( intercambiosDTO.getId() );
        }
        intercambiosPrestamos.setTipo( intercambiosDTO.getTipo() );
        intercambiosPrestamos.setEstado( intercambiosDTO.getEstado() );

        return intercambiosPrestamos;
    }
}
