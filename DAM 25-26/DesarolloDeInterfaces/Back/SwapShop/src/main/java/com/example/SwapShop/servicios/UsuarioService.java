package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.EstadisticasUsuarioDTO;
import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.exception.ElementoNoEncontradoException;
import com.example.SwapShop.exception.ResourceAlreadyExistsException; // Importar la excepción personalizada
import com.example.SwapShop.mapeadores.UsuarioMapper;
import com.example.SwapShop.modelos.Usuario;
import com.example.SwapShop.repositorios.IUsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional; // Importar Optional

@Service
@AllArgsConstructor
public class UsuarioService {

    private IUsuarioRepository usuarioRepository;
    private UsuarioMapper usuarioMapper;

    public UsuarioDTO crearUsuario(UsuarioDTO usuarioDTO) {
        // Verificar si ya existe un usuario con el mismo correo
        Optional<Usuario> existingUserByEmail = usuarioRepository.findByCorreo(usuarioDTO.getCorreo());
        if (existingUserByEmail.isPresent()) {
            throw new ResourceAlreadyExistsException("Ya existe un usuario con el correo: " + usuarioDTO.getCorreo());
        }

        // Verificar si ya existe un usuario con el mismo nombre de usuario
        Optional<Usuario> existingUserByUsername = usuarioRepository.findByNombreUsuario(usuarioDTO.getNombreUsuario());
        if (existingUserByUsername.isPresent()) {
            throw new ResourceAlreadyExistsException("Ya existe un usuario con el nombre de usuario: " + usuarioDTO.getNombreUsuario());
        }

        Usuario usuario = usuarioMapper.toEntity(usuarioDTO);
        Usuario usuarioGuardado = usuarioRepository.save(usuario);
        return usuarioMapper.toDTO(usuarioGuardado);
    }

    public UsuarioDTO buscarUsuarioPorId(Integer id) {
        // Usamos ElementoNoEncontradoException para ser más específicos
        Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new ElementoNoEncontradoException("Usuario no encontrado con id: " + id));
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
