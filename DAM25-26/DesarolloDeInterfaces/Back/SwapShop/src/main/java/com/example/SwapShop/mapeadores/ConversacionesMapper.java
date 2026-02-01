package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.ConversacionDTO;
import com.example.SwapShop.modelos.Conversaciones;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConversacionesMapper {

    Conversaciones toEntity(ConversacionDTO conversaciones);

    ConversacionDTO toDTO(Conversaciones conversaciones);
}
