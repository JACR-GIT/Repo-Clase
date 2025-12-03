package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.EstadisticasUsuarioDTO;
import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.mapeadores.UsuarioMapper;
import com.example.SwapShop.modelos.Usuario;
import com.example.SwapShop.repositorios.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UsuarioService {

    private IUsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuarioGuardado);
    }

    public UsuarioDTO buscarUsuarioPorId(Integer id) {
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado con id: " + id));
        return usuarioMapper.toDTO(usuario);
    }

    public EstadisticasUsuarioDTO usuarioConMasIntercambios() {
        return usuarioRepository.usuarioConMasIntercambios();
    }

    public List<UsuarioDTO> obtenerTodosLosUsuarios() {
        List<Usuario> usuarios = usuarioRepository.findAll();
        return usuarioMapper.toDTO(usuarios);
    }
}
