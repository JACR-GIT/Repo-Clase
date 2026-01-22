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
    public void crearPrendaIntegrationTest(){
        //Given

        PrendasDTO prenda = new PrendasDTO();
        prenda.setId_dueno(1);
        prenda.setNombrePrenda("Pantalón Vaquero");
        prenda.setDescripcion("Pantalón azul clásico");
        prenda.setTalla(Talla.L);
        prenda.setEstilo(Estilo.CASUAL);
        prenda.setCategoria(Categoria.PANTALON);
        prenda.setCondicion(Condicion.MUY_BUENA);
        prenda.setDisponible(true);

        Mockito.when(prendasRepository.save(Mockito.any(Prendas.class))).thenReturn(new Prendas());
        Mockito.when(prendasMapper.toDTO(Mockito.any(Prendas.class))).thenReturn(new PrendasDTO());
        Mockito.when(prendasMapper.toEntity(prenda)).thenReturn(new Prendas());

        //Then

        this.prendaService.crearPrenda(prenda);

        //When
        Mockito.verify(prendasRepository.save(Mockito.any(Prendas.class)));
        Mockito.verify(prendasMapper.toDTO(Mockito.any(Prendas.class)));
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
    public void modificarPrendaPorIdIntegrationTest(){
        // Given
        Integer idPrenda  = 1;

        // 1. Creamos el DTO de entrada (lo que llega desde el controller o cliente)
        PrendasDTO dtoModificado = new PrendasDTO();
        dtoModificado.setNombrePrenda("Camiseta Modificada");
        dtoModificado.setDescripcion("Descripción modificada");
        dtoModificado.setTalla(Talla.S);
        dtoModificado.setEstilo(Estilo.CASUAL);
        dtoModificado.setCategoria(Categoria.CAMISETA);
        dtoModificado.setCondicion(Condicion.EXCELENTE);
        dtoModificado.setDisponible(false);

        // 2. Entidad que SIMULAMOS que existe en la base de datos
        Prendas prendaExistente = new Prendas();
        // prendaExistente.setId(idExistente);   ← recomendable ponerlo
        // puedes poner más campos si tu mapper los usa

        // 3. Entidad después de aplicar cambios (la que se guarda)
        Prendas prendaActualizada = new Prendas();
        // prendaActualizada.setId(idExistente);
        // puedes copiar campos o dejar que el servicio los setee

        // Stubbing (mocks)
        Mockito.when(prendasRepository.findById(idPrenda))
                .thenReturn(Optional.of(prendaExistente));

        Mockito.when(prendasMapper.toEntity(dtoModificado))
                .thenReturn(prendaActualizada);   // o puedes devolver la misma prendaExistente si el mapper actualiza sobre existente

        Mockito.when(prendasRepository.save(Mockito.any(Prendas.class)))
                .thenReturn(prendaActualizada);

        Mockito.when(prendasMapper.toDTO(prendaActualizada))
                .thenReturn(dtoModificado);   // o un DTO nuevo con los valores actualizados

        // When
        PrendasDTO resultado = prendaService.modificarPrendaPorId(idPrenda, dtoModificado);

        // Verificaciones de interacciones
        Mockito.verify(prendasRepository).findById(idPrenda);
        Mockito.verify(prendasRepository).save(prendaActualizada);   // o any() si no te importa la referencia exacta
        Mockito.verify(prendasMapper).toDTO(prendaActualizada);
    }
}
