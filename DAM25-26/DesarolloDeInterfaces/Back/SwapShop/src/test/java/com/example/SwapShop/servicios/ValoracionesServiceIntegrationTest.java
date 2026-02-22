package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.dto.ValoracionesDTO;
import com.example.SwapShop.mapeadores.UsuarioMapper;
import com.example.SwapShop.mapeadores.ValoracionesMapper;
import com.example.SwapShop.modelos.Usuario;
import com.example.SwapShop.modelos.Valoraciones;
import com.example.SwapShop.repositorios.IValoracionesRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ValoracionesServiceIntegrationTest {

    @InjectMocks
    private ValoracionesServices valoracionesServices;

    @Mock
    private IValoracionesRepository valoracionesRepository;

    @Mock
    private ValoracionesMapper valoracionesMapper;

    @Mock
    private UsuarioService usarioService;

    @Mock
    private UsuarioMapper usuarioMapper;



    @Test
    public void crearValoracionIntegrationTest(){
        //Given

        ValoracionesDTO valoracionCreada = new ValoracionesDTO();
        valoracionCreada.setValorador(1);
        valoracionCreada.setPuntuacion(5);

        Mockito.when(valoracionesMapper.toDTO(Mockito.any(Valoraciones.class))).thenReturn(new ValoracionesDTO());
        Mockito.when(valoracionesMapper.toEntity(valoracionCreada)).thenReturn(new Valoraciones());
        Mockito.when(valoracionesRepository.save(Mockito.any(Valoraciones.class))).thenReturn(new Valoraciones());
        Mockito.when(usarioService.buscarUsuarioPorId(Mockito.anyInt())).thenReturn(new UsuarioDTO());
        Mockito.when(usuarioMapper.toEntity(Mockito.any(UsuarioDTO.class))).thenReturn(new Usuario());


        //Then

        this.valoracionesServices.crearValoracion(1, valoracionCreada);

        //When

        Mockito.verify(valoracionesRepository).save(Mockito.any());
    }
}
