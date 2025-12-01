package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.modelos.IntercambiosPrestamos;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IntercambiosPrestamosMapper {

    IntercambiosPrestamosDTO toDTO (IntercambiosPrestamos intercambios);

    IntercambiosPrestamos toEntity (IntercambiosPrestamosDTO intercambiosDTO);
}
