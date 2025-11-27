package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.modelos.Prendas;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PrendasMapper {

    Prendas toEntity (PrendasDTO prendasDTO);

    PrendasDTO toDTO (Prendas prendas);
}
