package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.MensajesDTO;
import com.example.SwapShop.modelos.Mensajes;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MensajesMapper {

    Mensajes toEntity(MensajesDTO mensajes);

    MensajesDTO toDTO(Mensajes mensajes);
}
