package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.modelos.IntercambiosPrestamos;
import com.example.SwapShop.modelos.Prendas;
import com.example.SwapShop.modelos.Usuario;
import com.example.SwapShop.repositorios.IPrendasRepository;
import com.example.SwapShop.repositorios.IUsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;

@Mapper(componentModel = "spring")
public abstract class IntercambiosPrestamosMapper {

    @Autowired
    protected IUsuarioRepository usuarioRepository;
    @Autowired
    protected IPrendasRepository prendasRepository;

    @Mapping(source = "prenda.id", target = "id_prenda")
    @Mapping(source = "prenda2.id", target = "id_prenda2")
    @Mapping(source = "solicitante.id", target = "id_solicitante")
    @Mapping(source = "dueno.id", target = "id_dueno")
    @Mapping(source = "fechaInicio", target = "fecha_inicio")
    @Mapping(source = "fechaFin", target = "fecha_fin")
    public abstract IntercambiosPrestamosDTO toDTO(IntercambiosPrestamos intercambios);

    @Mapping(source = "id_prenda", target = "prenda")
    @Mapping(source = "id_prenda2", target = "prenda2")
    @Mapping(source = "id_solicitante", target = "solicitante")
    @Mapping(source = "id_dueno", target = "dueno")
    @Mapping(source = "fecha_inicio", target = "fechaInicio")
    @Mapping(source = "fecha_fin", target = "fechaFin")
    public abstract IntercambiosPrestamos toEntity(IntercambiosPrestamosDTO intercambiosDTO);

    @Mapping(source = "id_prenda", target = "prenda")
    @Mapping(source = "id_prenda2", target = "prenda2")
    @Mapping(source = "id_solicitante", target = "solicitante")
    @Mapping(source = "id_dueno", target = "dueno")
    @Mapping(source = "fecha_inicio", target = "fechaInicio")
    @Mapping(source = "fecha_fin", target = "fechaFin")
    public abstract void updateEntityFromDto(IntercambiosPrestamosDTO dto, @MappingTarget IntercambiosPrestamos entity);


    protected Usuario usuarioFromId(Integer id) {
        if (id == null) {
            return null;
        }
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado con id: " + id));
    }

    protected Prendas prendaFromId(Integer id) {
        if (id == null) {
            return null;
        }
        return prendasRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Prenda no encontrada con id: " + id));
    }
}
