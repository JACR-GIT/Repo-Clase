package com.example.SwapShop.mapeadores;

import com.example.SwapShop.dto.ValoracionesDTO;
import com.example.SwapShop.modelos.Usuario;
import com.example.SwapShop.modelos.Valoraciones;
import com.example.SwapShop.repositorios.IUsuarioRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.NoSuchElementException;

@Mapper(componentModel = "spring") // Eliminamos uses = {UsuarioMapper.class} ya que ahora mapeamos IDs directamente
public abstract class ValoracionesMapper {

    @Autowired
    protected IUsuarioRepository usuarioRepository;

    @Mapping(source = "valorador.id", target = "valorador")
    @Mapping(source = "valorado.id", target = "valorado")
    public abstract ValoracionesDTO toDTO(Valoraciones valoraciones);

    @Mapping(source = "valorador", target = "valorador") // MapStruct usará usuarioFromId
    @Mapping(source = "valorado", target = "valorado")   // MapStruct usará usuarioFromId
    public abstract Valoraciones toEntity(ValoracionesDTO valoracionesDTO);

    protected Usuario usuarioFromId(Integer id) {
        if (id == null) {
            return null;
        }
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Usuario no encontrado con id: " + id));
    }
}
