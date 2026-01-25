package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.mapeadores.PrendasMapper;
import com.example.SwapShop.modelos.*;
import com.example.SwapShop.repositorios.IPrendasRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class PrendasServiceIntegrationTest {

    @InjectMocks
    private PrendaService prendaService;

    @Mock
    private IPrendasRepository prendasRepository;

    @Mock
    private PrendasMapper prendasMapper;


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
                new Prendas(),  // al menos 1 prenda para que !isEmpty()
                new Prendas()
        );

        List<PrendasDTO> dtosMock = List.of(
                new PrendasDTO(),
                new PrendasDTO()
        );

        // ← AQUÍ EL CAMBIO CLAVE: thenReturn(LISTA_REAL) NO anyList()
        Mockito.when(prendasRepository.buscarPorTalla(tallaBuscada)).thenReturn(prendasMock);
        Mockito.when(prendasMapper.listToDTOs(prendasMock)).thenReturn(dtosMock);

//        Mockito.when(prendasRepository.buscarPorTalla(Mockito.anyString())).thenReturn(Mockito.anyList());
//        Mockito.when(prendasMapper.listToDTOs(Mockito.anyList())).thenReturn(Mockito.anyList());

        //Then

        this.prendaService.buscarPrendaPorTalla(tallaBuscada);

        //When

        Mockito.verify(prendasRepository).buscarPorTalla(tallaBuscada);
        Mockito.verify(prendasMapper).listToDTOs(prendasMock);

//        Mockito.verify(prendasRepository).buscarPorTalla(Mockito.anyString());
//        Mockito.verify(prendasMapper).listToDTOs(Mockito.anyList());
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
        // devuelve la misma entidad modificada

        Mockito.when(prendasMapper.toDTO(Mockito.any(Prendas.class)))
                .thenReturn(dtoModificado);

        // When
        prendaService.modificarPrendaPorId(idPrenda, dtoModificado);

        // Then
        Mockito.verify(prendasRepository).findById(idPrenda);
        Mockito.verify(prendasRepository).save(prendaExistente);
        Mockito.verify(prendasMapper).toDTO(prendaExistente);
    }

}
