package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.exception.ElementoNoEncontradoException;
import com.example.SwapShop.mapeadores.PrendasMapper;
import com.example.SwapShop.modelos.*;
import com.example.SwapShop.repositorios.IIntercambiosPrestamosRepository;
import com.example.SwapShop.repositorios.IPrendasRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;

import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class PrendasServiceIntegrationTest {

    @InjectMocks
    private PrendaService prendaService;

    @Mock
    private IPrendasRepository prendasRepository;

    @Mock
    private PrendasMapper prendasMapper;

    @Mock
    private IIntercambiosPrestamosRepository intercambiosPrestamosRepository;


    @Test
    @DisplayName("Test de integracion -> crearPrenda()")
    public void crearPrendaIntegrationTest() {

        // Given
        PrendasDTO prendaDto = new PrendasDTO();
        prendaDto.setNombrePrenda("Pantalón Vaquero");
        prendaDto.setTalla(Talla.L);
        prendaDto.setCategoria(Categoria.PANTALON);
        prendaDto.setCondicion(Condicion.MUY_BUENA);
        prendaDto.setId_dueno(1);

        Prendas prendaEntity = new Prendas();
        Prendas prendaGuardada = new Prendas();
        PrendasDTO prendaDtoResultado = new PrendasDTO();

        Mockito.when(prendasMapper.toEntity(Mockito.any(PrendasDTO.class)))
                .thenReturn(prendaEntity);

        Mockito.when(prendasRepository.save(Mockito.any(Prendas.class)))
                .thenReturn(prendaGuardada);

        Mockito.when(prendasMapper.toDTO(Mockito.any(Prendas.class)))
                .thenReturn(prendaDtoResultado);

        // When
        PrendasDTO resultado = prendaService.crearPrenda(prendaDto);

        // Then
        Mockito.verify(prendasRepository).save(prendaEntity);
        Mockito.verify(prendasMapper).toDTO(prendaGuardada);
    }


    @Test
    @DisplayName("Test de integracion -> buscarPrendaPorTalla()")
    public void  buscarPrendaPorTallaIntegrationTest(){
        //Given

        String tallaBuscada = "L";

        List<Prendas> prendasMock = List.of(
                new Prendas(),
                new Prendas()
        );

        List<PrendasDTO> dtosMock = List.of(
                new PrendasDTO(),
                new PrendasDTO()
        );

        Mockito.when(prendasRepository.buscarPorTalla(tallaBuscada)).thenReturn(prendasMock);
        Mockito.when(prendasMapper.listToDTOs(prendasMock)).thenReturn(dtosMock);

        //Then

        this.prendaService.buscarPrendaPorTalla(tallaBuscada);

        //When

        Mockito.verify(prendasRepository).buscarPorTalla(tallaBuscada);
        Mockito.verify(prendasMapper).listToDTOs(prendasMock);

    }

    @Test
    @DisplayName("Test de integracion -> modificarPrendaPorId()")
    public void modificarPrendaPorIdIntegrationTest() {

        // Given
        Integer idPrenda = 1;

        PrendasDTO dtoModificado = new PrendasDTO();
        dtoModificado.setNombrePrenda("Camiseta Modificada");
        dtoModificado.setDescripcion("Descripción modificada");
        dtoModificado.setTalla(Talla.S);
        dtoModificado.setEstilo(Estilo.CASUAL);
        dtoModificado.setCategoria(Categoria.CAMISETA);
        dtoModificado.setCondicion(Condicion.EXCELENTE);
        dtoModificado.setDisponible(false);

        Prendas prendaExistente = new Prendas();
        prendaExistente.setId(idPrenda);

        Mockito.when(prendasRepository.findById(idPrenda))
                .thenReturn(Optional.of(prendaExistente));

        Mockito.when(prendasRepository.save(Mockito.any(Prendas.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Mockito.when(prendasMapper.toDTO(Mockito.any(Prendas.class)))
                .thenReturn(dtoModificado);

        // When
        prendaService.modificarPrendaPorId(idPrenda, dtoModificado);

        // Then
        Mockito.verify(prendasRepository).findById(idPrenda);
        Mockito.verify(prendasRepository).save(prendaExistente);
        Mockito.verify(prendasMapper).toDTO(prendaExistente);
    }

    @Test
    @DisplayName("Test de integracion -> top5PrendasMasIntercambiadasAceptadas()")
    public void top5PrendasMasIntercambiadasAceptadasIntegrationTest() {
        // Given
        Pageable top5Pageable = PageRequest.of(0, 5);

        Mockito.when(intercambiosPrestamosRepository.buscarTop5Intercambio(top5Pageable))
                .thenReturn(List.of());

        // When
        try {
            prendaService.top5PrendasMasIntercambiadasAceptadas();
        } catch (ElementoNoEncontradoException e) {
            assertEquals("No se encontraron prendas intercambiadas aceptadas.", e.getMessage());
        }

        // Then
        Mockito.verify(intercambiosPrestamosRepository).buscarTop5Intercambio(top5Pageable);
        Mockito.verifyNoMoreInteractions(intercambiosPrestamosRepository);
    }

}
