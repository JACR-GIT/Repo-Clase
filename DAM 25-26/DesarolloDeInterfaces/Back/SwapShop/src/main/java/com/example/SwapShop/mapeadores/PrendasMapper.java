package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.EstadisticasPrendaDTO;
import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.modelos.Prendas;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrendasMapper {

    Prendas toEntity (PrendasDTO prendasDTO);

    PrendasDTO toDTO (Prendas prendas);

    List <PrendasDTO> listToDTOs (List<Prendas> prendasList);
    List <EstadisticasPrendaDTO> listEstadisticasToDTOs (List<Prendas> prendasDTOList);

    List <Prendas> listToEntities (List<PrendasDTO> prendasDTOList);
}
