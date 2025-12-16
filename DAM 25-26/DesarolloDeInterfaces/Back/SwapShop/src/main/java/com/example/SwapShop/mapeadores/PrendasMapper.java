package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.modelos.Prendas;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PrendasMapper {

    @Mapping(source = "id_dueno", target = "dueno.id")
    Prendas toEntity(PrendasDTO prendasDTO);

    @Mapping(source = "dueno.id", target = "id_dueno")
    PrendasDTO toDTO(Prendas prendas);

    List<PrendasDTO> listToDTOs(List<Prendas> prendasList);

    List<Prendas> listToEntities(List<PrendasDTO> prendasDTOList);
}
