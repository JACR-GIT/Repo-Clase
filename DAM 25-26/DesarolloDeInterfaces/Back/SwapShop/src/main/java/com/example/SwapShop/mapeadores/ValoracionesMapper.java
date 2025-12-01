package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.ValoracionesDTO;
import com.example.SwapShop.modelos.Valoraciones;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ValoracionesMapper {

    Valoraciones toEntity(ValoracionesDTO valoraciones);

    ValoracionesDTO toDTO(Valoraciones valoraciones);
}
