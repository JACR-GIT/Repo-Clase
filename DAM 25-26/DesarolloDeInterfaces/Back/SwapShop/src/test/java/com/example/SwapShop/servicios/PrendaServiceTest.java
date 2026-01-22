package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.exception.ElementoNoEncontradoException;
import com.example.SwapShop.modelos.*;
import com.example.SwapShop.repositorios.IPrendasRepository;
import com.example.SwapShop.repositorios.IUsuarioRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PrendaServiceTest {

    @Autowired
    private PrendaService prendaService;

    @Autowired
    private IPrendasRepository prendasRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @BeforeAll
    void cargarDatos(){

        Usuario usuario1 = new Usuario();
        usuario1.setNombreUsuario("usuario1");
        usuario1.setCorreo("correo1");
        usuario1.setContrasena("contrasena1");
        usuario1.setNombre("nombre1");
        usuario1.setApellido1("apellido1");
        usuario1.setApellido2("apellido2");
        usuario1.setFecha_nac(Date.valueOf(LocalDate.of(1990, 1, 1)));

        usuarioRepository.save(usuario1);

        Prendas prenda1 = new Prendas();
        prenda1.setDueno(usuario1);
        prenda1.setNombrePrenda("Camiseta Vintage");
        prenda1.setDescripcion("Camiseta de los 90");
        prenda1.setTalla(Talla.M);
        prenda1.setEstilo(Estilo.VINTAGE);
        prenda1.setCategoria(Categoria.CAMISETA);
        prenda1.setCondicion(Condicion.BUENA);
        prenda1.setDisponible(true);

        Prendas prenda2 = new Prendas();
        prenda2.setDueno(usuario1);
        prenda2.setNombrePrenda("Pantalón Vaquero");
        prenda2.setDescripcion("Pantalón azul clásico");
        prenda2.setTalla(Talla.L);
        prenda2.setEstilo(Estilo.CASUAL);
        prenda2.setCategoria(Categoria.PANTALON);
        prenda2.setCondicion(Condicion.MUY_BUENA);
        prenda2.setDisponible(true);

//        prendasRepository.save(prenda1);
//        prendasRepository.save(prenda2);

    }

    @Test
    @DisplayName("Servicio 3 -> Caso Positivo")
    void crearPrendaTest() {
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

        //Then

        PrendasDTO prendaCreada = prendaService.crearPrenda(prenda);

        //When
        assertNotNull(prendaCreada, "No puede ser nulo");
        assertNotNull(prendaCreada.getId(), "No puede tener un id nulo");
        assertEquals(prendaCreada.getNombrePrenda(), prenda.getNombrePrenda(), "El nombre de la prenda no coincide");
        assertEquals(prendaCreada.getTalla(), prenda.getTalla(), "La talla no coincide");
        assertEquals(prendaCreada.getCategoria(), prenda.getCategoria(), "La categoría no coincide");
        assertEquals(prendaCreada.getCondicion(), prenda.getCondicion(), "La condición no coincide");
        assertEquals(prendaCreada.getDescripcion(), prenda.getDescripcion(), "La descripción no coincide");
        assertEquals(prendaCreada.getDisponible(), prenda.getDisponible(), "El estado de disponibilidad no coincide");
        assertEquals(prendaCreada.getId_dueno(), prenda.getId_dueno(), "El id del dueño no coincide");
        assertEquals(prendaCreada.getFoto(), prenda.getFoto(), "La foto no coincide");
        assertEquals(prendaCreada.getEstilo(), prenda.getEstilo(), "El estilo no coincide");

    }

    @Test
    @DisplayName("Servicio 3 -> Caso Negativo")
    void crearPrendaNegativo() {
        //Given
        PrendasDTO prendaSinTalla = new PrendasDTO();
        prendaSinTalla.setId_dueno(1);
        prendaSinTalla.setNombrePrenda("Pantalón");
        prendaSinTalla.setCategoria(Categoria.PANTALON);
        prendaSinTalla.setCondicion(Condicion.MUY_BUENA);

        //Then

        //When
        assertThrows(IllegalArgumentException.class, () -> prendaService.crearPrenda(prendaSinTalla));
    }

    @Test
    @DisplayName("Servicio 4 -> Caso Positivo")
    void buscarPrendaPorTalla() {
        //Given

        //Then
        
        List<PrendasDTO> prendasBuscada = prendaService.buscarPrendaPorTalla("L");
        
        //When
        assertNotNull(prendasBuscada, "La lista de prendas no debería ser nula");
        assertFalse(prendasBuscada.isEmpty(), "La lista de prendas no debería estar vacía");
        assertFalse(prendasBuscada.contains(null), "La lista de prendas no debería contener elementos nulos");
        assertEquals(1, prendasBuscada.size(), "Debería haber encontrado 1 prenda de talla L");
        assertEquals(Talla.L, prendasBuscada.get(0).getTalla(), "La talla de la prenda encontrada debería ser L");
    }

    @Test
    @DisplayName("Servicio 4 -> Caso Negativo")
    void buscarPrendaPorTallaNegativo() {
        //Given

        //Then

        //When
        assertThrows(ElementoNoEncontradoException.class, () -> prendaService.buscarPrendaPorTalla("XL"));
    }

    @Test
    @DisplayName("Servicio 5 -> Caso Positivo")
    void modificarPrendaPorId() {
        //Given

        PrendasDTO prendaModificada = new PrendasDTO();
        prendaModificada.setNombrePrenda("Camiseta Modificada");
        prendaModificada.setDescripcion("Descripción modificada");
        prendaModificada.setTalla(Talla.S);
        prendaModificada.setEstilo(Estilo.CASUAL);
        prendaModificada.setCategoria(Categoria.CAMISETA);
        prendaModificada.setCondicion(Condicion.EXCELENTE);
        prendaModificada.setDisponible(false);

        //Then

        prendaService.modificarPrendaPorId(1, prendaModificada);

        //When

        assertNotNull(prendaModificada, "La prenda modificada no debe ser nula");
        assertEquals("Camiseta Modificada", prendaModificada.getNombrePrenda(), "El nombre no se actualizó");
        assertEquals("Descripción modificada", prendaModificada.getDescripcion(), "La descripción no se actualizó");
        assertEquals(Talla.S, prendaModificada.getTalla(), "La talla no se actualizó");
        assertEquals(Estilo.CASUAL, prendaModificada.getEstilo(), "El estilo no se actualizó");
        assertEquals(Categoria.CAMISETA, prendaModificada.getCategoria(), "La categoría no se actualizó");
        assertEquals(Condicion.EXCELENTE, prendaModificada.getCondicion(), "La condición no se actualizó");
        assertEquals(false, prendaModificada.getDisponible(), "La disponibilidad no se actualizó");
    }

    @Test
    @DisplayName("Servicio 5 -> Caso Negativo")
    void modificarPrendaPorIdNegativo() {
        //Given

        PrendasDTO prendaModificada = new PrendasDTO();
        prendaModificada.setNombrePrenda("Camiseta Modificada");
        prendaModificada.setDescripcion("Descripción modificada");
        prendaModificada.setTalla(Talla.S);
        prendaModificada.setEstilo(Estilo.CASUAL);
        prendaModificada.setCategoria(Categoria.CAMISETA);
        prendaModificada.setCondicion(Condicion.EXCELENTE);
        prendaModificada.setDisponible(false);

        //Then


        //When
        assertThrows(NoSuchElementException.class, () -> prendaService.modificarPrendaPorId(4, prendaModificada));

    }

    @Test
    @DisplayName("Servicio 9 -> Caso Positivo")
    void top5PrendasMasIntercambiadasAceptadas() {
        //Given

        //Then

        //When
        assertNotNull(prendaService.top5PrendasMasIntercambiadasAceptadas(), "No se encontraron prendas intercambiadas aceptadas.");

    }

    @Test
    @DisplayName("Servicio 9 -> Caso Negativo")
    void top5PrendasMasIntercambiadasAceptadasNegativo() {
        //Given

        //Then

        //When
        assertThrows(ElementoNoEncontradoException.class, () -> prendaService.top5PrendasMasIntercambiadasAceptadas());
    }

}
