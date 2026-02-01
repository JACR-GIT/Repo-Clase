package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.EstadisticasUsuarioDTO;
import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.mapeadores.UsuarioMapper;
import com.example.SwapShop.modelos.EstadoIntercambio;
import com.example.SwapShop.modelos.Usuario;
import com.example.SwapShop.repositorios.IUsuarioRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class UsuarioServiceIntegrationTest {

    @InjectMocks
    private UsuarioService usuarioService;

    @Mock
    private IUsuarioRepository usuarioRepository;

    @Mock
    private UsuarioMapper usuarioMapper;


    @Test
    @DisplayName("Test de integracion -> crearUsuario()")
    public void crearUsuarioIntegrationTest(){
        //Given

        UsuarioDTO nuevoUsuarioDTO = new UsuarioDTO();
        nuevoUsuarioDTO.setNombreUsuario("usuario3");
        nuevoUsuarioDTO.setCorreo("correo3");
        nuevoUsuarioDTO.setContrasena("contrasena3");
        nuevoUsuarioDTO.setNombre("nombre3");
        nuevoUsuarioDTO.setApellido1("apellido3");
        nuevoUsuarioDTO.setApellido2("apellido3");
        nuevoUsuarioDTO.setFecha_nac(Date.valueOf(LocalDate.of(1990, 1, 1)));

        Mockito.when(this.usuarioMapper.toEntity(nuevoUsuarioDTO)).thenReturn(new Usuario());
        Mockito.when(this.usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(new Usuario());
        Mockito.when(this.usuarioMapper.toDTO(Mockito.any(Usuario.class))).thenReturn(new UsuarioDTO());

        //Then

        this.usuarioService.crearUsuario(nuevoUsuarioDTO);

        //When
        Mockito.verify(this.usuarioRepository).save(Mockito.any());
        Mockito.verify(this.usuarioMapper).toDTO(Mockito.any(Usuario.class));
    }

    @Test
    @DisplayName("Test de integracion -> buscarUsuarioPorId()")
    public void buscarUsuarioPorIdIntegrationTest(){
        //Given

        Mockito.when(this.usuarioRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new Usuario()));
        Mockito.when(this.usuarioMapper.toDTO(Mockito.any(Usuario.class))).thenReturn(new UsuarioDTO());

        //Then

        this.usuarioService.buscarUsuarioPorId(1);

        //When
        Mockito.verify(this.usuarioRepository).findById(Mockito.anyInt());
        Mockito.verify(this.usuarioMapper).toDTO(Mockito.any(Usuario.class));
    }

    @Test
    @DisplayName("Test de integracion -> usuarioConMasIntercambios()")

    public void usuarioConMasIntercambiosIntegrationTest(){

        EstadisticasUsuarioDTO dto = new EstadisticasUsuarioDTO();
        List<EstadisticasUsuarioDTO> lista = List.of(dto);

        //Given
        Mockito.when(this.usuarioRepository.findUsuarioConMasIntercambios(Mockito.any(EstadoIntercambio.class), Mockito.any())).thenReturn(lista);

        //Then

        this.usuarioService.usuarioConMasIntercambios();

        //When
        Mockito.verify(this.usuarioRepository).findUsuarioConMasIntercambios(Mockito.any(), Mockito.any());
    }
}
