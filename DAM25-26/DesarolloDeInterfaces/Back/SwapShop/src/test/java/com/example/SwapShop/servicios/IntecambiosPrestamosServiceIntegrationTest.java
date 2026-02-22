package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.mapeadores.IntercambiosPrestamosMapper;
import com.example.SwapShop.modelos.EstadoIntercambio;
import com.example.SwapShop.modelos.IntercambiosPrestamos;
import com.example.SwapShop.modelos.TipoIntercambio;
import com.example.SwapShop.repositorios.IIntercambiosPrestamosRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;

@SpringBootTest
public class IntecambiosPrestamosServiceIntegrationTest {

    @InjectMocks
    private IntercambiosPrestamosService intercambiosPrestamosService;

    @Mock
    private IIntercambiosPrestamosRepository intercambiosPrestamosRepository;

    @Mock
    private IntercambiosPrestamosMapper intercambiosPrestamosMapper;

    @Test
    @DisplayName("Test de integracion -> crearIntercambioPrestamo()")
    public void crearIntercambioIntafrationTest(){

        //Given
        IntercambiosPrestamosDTO dto = new IntercambiosPrestamosDTO();
        dto.setEstado(EstadoIntercambio.ACEPTADO);
        dto.setTipo(TipoIntercambio.INTERCAMBIO);
        dto.setFecha_inicio(Date.valueOf(LocalDate.now()));
        dto.setFecha_fin(Date.valueOf(LocalDate.now().plusDays(7)));
        dto.setId_dueno(1);
        dto.setId_solicitante(2);
        dto.setId_prenda(1);
        dto.setId_prenda2(2);

        Mockito.when(this.intercambiosPrestamosMapper.toEntity(Mockito.any(IntercambiosPrestamosDTO.class))).thenReturn(new IntercambiosPrestamos());
        Mockito.when(this.intercambiosPrestamosRepository.save(Mockito.any(IntercambiosPrestamos.class))).thenReturn(new IntercambiosPrestamos());
        Mockito.when(this.intercambiosPrestamosMapper.toDTO(Mockito.any(IntercambiosPrestamos.class))).thenReturn(new IntercambiosPrestamosDTO());
        //Then

        this.intercambiosPrestamosService.crearIntercambioPrestamo(dto);

        //When

        Mockito.verify(this.intercambiosPrestamosRepository).save(Mockito.any());
        Mockito.verify(this.intercambiosPrestamosMapper).toDTO(Mockito.any(IntercambiosPrestamos.class));
    }

    @Test
    @DisplayName("Test de integracion -> cambiarEstado()")
    public void cambiarEstadoIntegrationTest(){
        //Given

        Mockito.when(this.intercambiosPrestamosRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(new IntercambiosPrestamos()));
        Mockito.when(this.intercambiosPrestamosRepository.save(Mockito.any(IntercambiosPrestamos.class))).thenReturn(new IntercambiosPrestamos());
        //Then

        this.intercambiosPrestamosService.cambiarEstado(1, EstadoIntercambio.ACEPTADO);

        //When

        Mockito.verify(this.intercambiosPrestamosRepository).findById(Mockito.anyInt());
        Mockito.verify(this.intercambiosPrestamosRepository).save(Mockito.any());
        Mockito.verify(this.intercambiosPrestamosMapper).toDTO(Mockito.any(IntercambiosPrestamos.class));
    }
}
