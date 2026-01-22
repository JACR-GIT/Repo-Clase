package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.modelos.*;
import com.example.SwapShop.repositorios.IIntercambiosPrestamosRepository;
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

import java.sql.Date;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntercambiosPrestamosServiceTest {

    @Autowired
    private IntercambiosPrestamosService intercambiosPrestamosService;

    @Autowired
    private IIntercambiosPrestamosRepository intercambiosPrestamosRepository;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IPrendasRepository prendasRepository;


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

        Usuario usuario2 = new Usuario();
        usuario2.setNombreUsuario("usuario2");
        usuario2.setCorreo("correo2");
        usuario2.setContrasena("contrasena1");
        usuario2.setNombre("nombre1");
        usuario2.setApellido1("apellido1");
        usuario2.setApellido2("apellido2");
        usuario2.setFecha_nac(Date.valueOf(LocalDate.of(1990, 1, 1)));

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

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
        prenda2.setDueno(usuario2);
        prenda2.setNombrePrenda("Pantalón Vaquero");
        prenda2.setDescripcion("Pantalón azul clásico");
        prenda2.setTalla(Talla.L);
        prenda2.setEstilo(Estilo.CASUAL);
        prenda2.setCategoria(Categoria.PANTALON);
        prenda2.setCondicion(Condicion.MUY_BUENA);
        prenda2.setDisponible(true);

        prendasRepository.save(prenda1);
        prendasRepository.save(prenda2);

        IntercambiosPrestamos intercambio1 = new IntercambiosPrestamos();
        intercambio1.setEstado(EstadoIntercambio.ACEPTADO);
        intercambio1.setTipo(TipoIntercambio.INTERCAMBIO);
        intercambio1.setFechaInicio(Date.valueOf(LocalDate.now()));
        intercambio1.setFechaFin(Date.valueOf(LocalDate.now().plusDays(7)));
        intercambio1.setDueno(usuario1);
        intercambio1.setSolicitante(usuario2);
        intercambio1.setPrenda(prenda1);
        intercambio1.setPrenda2(prenda2);

        IntercambiosPrestamos intercambio2 = new IntercambiosPrestamos();
        intercambio2.setEstado(EstadoIntercambio.ACEPTADO);
        intercambio2.setTipo(TipoIntercambio.INTERCAMBIO);
        intercambio2.setFechaInicio(Date.valueOf(LocalDate.now()));
        intercambio2.setFechaFin(Date.valueOf(LocalDate.now().plusDays(7)));
        intercambio2.setDueno(usuario1);
        intercambio2.setSolicitante(usuario2);
        intercambio2.setPrenda(prenda1);
        intercambio2.setPrenda2(prenda2);

        intercambiosPrestamosRepository.save(intercambio1);
        intercambiosPrestamosRepository.save(intercambio2);
    }

    @Test
    @DisplayName("Servicio 6 -> Caso Positivo")
    void crearIntercambioPrestamoTest() {
        //Given

        IntercambiosPrestamosDTO intercambioNuevo = new IntercambiosPrestamosDTO();
        intercambioNuevo.setEstado(EstadoIntercambio.ACEPTADO);
        intercambioNuevo.setTipo(TipoIntercambio.INTERCAMBIO);
        intercambioNuevo.setFecha_inicio(Date.valueOf(LocalDate.now()));
        intercambioNuevo.setFecha_fin(Date.valueOf(LocalDate.now().plusDays(7)));
        intercambioNuevo.setId_dueno(1);
        intercambioNuevo.setId_solicitante(2);
        intercambioNuevo.setId_prenda(1);
        intercambioNuevo.setId_prenda2(2);

        //Then

       IntercambiosPrestamosDTO intercambioGuardado = intercambiosPrestamosService.crearIntercambioPrestamo(intercambioNuevo);

        //When

        assertNotNull(intercambioGuardado, "El intercambio creado no debería ser nulo.");
        assertNotNull(intercambioGuardado.getId(), "El intercambio creado debería tener un ID.");
        assertEquals(EstadoIntercambio.ACEPTADO, intercambioGuardado.getEstado(), "El estado del intercambio no coincide");
        assertEquals(TipoIntercambio.INTERCAMBIO, intercambioGuardado.getTipo(), "El tipo de intercambio no coincide");
        assertEquals(Date.valueOf(LocalDate.now()), intercambioGuardado.getFecha_inicio(), "La fecha de inicio del intercambio no coincide");
        assertEquals(Date.valueOf(LocalDate.now().plusDays(7)), intercambioGuardado.getFecha_fin(), "La fecha de fin");
        assertEquals(1, intercambioGuardado.getId_dueno(), "El id del dueño no coincide");
        assertEquals(2, intercambioGuardado.getId_solicitante(), "El id del solicitante no coincide");
        assertEquals(1, intercambioGuardado.getId_prenda(), "El id de la prenda no coincide");
        assertEquals(2, intercambioGuardado.getId_prenda2(), "El id de la prenda2 no coincide");

    }

    @Test
    @DisplayName("Servicio 6 -> Caso Negativo")
    void crearIntercambioPrestamoTestNegativo() {
        //Given
        IntercambiosPrestamosDTO intercambioNuevo = new IntercambiosPrestamosDTO();
        intercambioNuevo.setId(3);
        intercambioNuevo.setEstado(null);
        intercambioNuevo.setTipo(null);
        intercambioNuevo.setFecha_inicio(null);
        intercambioNuevo.setFecha_fin(null);
        intercambioNuevo.setId_dueno(null);
        intercambioNuevo.setId_solicitante(null);
        intercambioNuevo.setId_prenda(null);
        intercambioNuevo.setId_prenda2(null);

        //Then

        //When
        assertThrows(IllegalArgumentException.class, () -> intercambiosPrestamosService.crearIntercambioPrestamo(intercambioNuevo));
        assertThrows(IllegalArgumentException.class, () -> intercambiosPrestamosService.crearIntercambioPrestamo(intercambioNuevo));
        assertThrows(IllegalArgumentException.class, () -> intercambiosPrestamosService.crearIntercambioPrestamo(intercambioNuevo));
        assertThrows(IllegalArgumentException.class, () -> intercambiosPrestamosService.crearIntercambioPrestamo(intercambioNuevo));
        assertThrows(IllegalArgumentException.class, () -> intercambiosPrestamosService.crearIntercambioPrestamo(intercambioNuevo));
        assertThrows(IllegalArgumentException.class, () -> intercambiosPrestamosService.crearIntercambioPrestamo(intercambioNuevo));
        assertThrows(IllegalArgumentException.class, () -> intercambiosPrestamosService.crearIntercambioPrestamo(intercambioNuevo));

    }

    @Test
    @DisplayName("Servicio 7 -> Caso Positivo")
    void cambiarEstadoTest() {
        //Given

        //Then

        IntercambiosPrestamosDTO intercambioDTO = intercambiosPrestamosService.cambiarEstado(1, EstadoIntercambio.FINALIZADO);

        //When

        assertEquals(EstadoIntercambio.FINALIZADO, intercambioDTO.getEstado(), "El estado del intercambio no coincide");
    }

    @Test
    @DisplayName("Servicio 7 -> Caso Negativo")
    void cambiarEstadoTestNegativo() {
        //Given

        //Then

        //When
        assertThrows(IllegalArgumentException.class, () -> intercambiosPrestamosService.cambiarEstado(1, null));
        assertThrows(IllegalArgumentException.class, () -> intercambiosPrestamosService.cambiarEstado(null, EstadoIntercambio.FINALIZADO));
    }

}
