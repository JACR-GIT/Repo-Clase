package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.modelos.Prendas;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-12T13:55:38+0100",
    comments = "version: 1.6.3, compiler: javac, environment: Java 21.0.9 (Microsoft)"
)
@Component
public class PrendasMapperImpl implements PrendasMapper {

    @Override
    public Prendas toEntity(PrendasDTO prendasDTO) {
        if ( prendasDTO == null ) {
            return null;
        }

        Prendas prendas = new Prendas();

        if ( prendasDTO.getId() != null ) {
            prendas.setId( prendasDTO.getId() );
        }
        prendas.setId_dueno( prendasDTO.getId_dueno() );
        prendas.setDescripcion( prendasDTO.getDescripcion() );
        prendas.setTalla( prendasDTO.getTalla() );
        prendas.setCategoria( prendasDTO.getCategoria() );
        prendas.setCondicion( prendasDTO.getCondicion() );
        prendas.setDisponible( prendasDTO.getDisponible() );

        return prendas;
    }

    @Override
    public PrendasDTO toDTO(Prendas prendas) {
        if ( prendas == null ) {
            return null;
        }

        PrendasDTO prendasDTO = new PrendasDTO();

        prendasDTO.setId( prendas.getId() );
        prendasDTO.setId_dueno( prendas.getId_dueno() );
        prendasDTO.setDescripcion( prendas.getDescripcion() );
        prendasDTO.setTalla( prendas.getTalla() );
        prendasDTO.setCategoria( prendas.getCategoria() );
        prendasDTO.setCondicion( prendas.getCondicion() );
        prendasDTO.setDisponible( prendas.getDisponible() );

        return prendasDTO;
    }

    @Override
    public List<PrendasDTO> listToDTOs(List<Prendas> prendasList) {
        if ( prendasList == null ) {
            return null;
        }

        List<PrendasDTO> list = new ArrayList<PrendasDTO>( prendasList.size() );
        for ( Prendas prendas : prendasList ) {
            list.add( toDTO( prendas ) );
        }

        return list;
    }

    @Override
    public List<Prendas> listToEntities(List<PrendasDTO> prendasDTOList) {
        if ( prendasDTOList == null ) {
            return null;
        }

        List<Prendas> list = new ArrayList<Prendas>( prendasDTOList.size() );
        for ( PrendasDTO prendasDTO : prendasDTOList ) {
            list.add( toEntity( prendasDTO ) );
        }

        return list;
    }
}
