package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.modelos.IntercambiosPrestamos;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface IntercambiosPrestamosMapper {


    @Mapping(source = "dueno", target = "id_dueno")
    @Mapping(source = "solicitante", target = "id_solicitante")
    @Mapping(source = "prenda", target = "id_prenda")
    @Mapping(source = "prenda2", target = "id_prenda2")
    @Mapping(source = "fechaInicio", target = "fecha_inicio")
    @Mapping(source = "fechaFin", target = "fecha_fin")
    IntercambiosPrestamosDTO toDTO (IntercambiosPrestamos intercambios);

    @Mapping(source = "id_dueno", target = "dueno")
    @Mapping(source = "id_solicitante", target = "solicitante")
    @Mapping(source = "id_prenda", target = "prenda")
    @Mapping(source = "id_prenda2", target = "prenda2")
    @Mapping(source = "fecha_inicio", target = "fechaInicio")
    @Mapping(source = "fecha_fin", target = "fechaFin")
    IntercambiosPrestamos toEntity (IntercambiosPrestamosDTO intercambiosDTO);
}
