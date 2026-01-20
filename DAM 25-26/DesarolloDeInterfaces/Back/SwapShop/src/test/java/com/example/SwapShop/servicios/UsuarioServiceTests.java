package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.EstadisticasUsuarioDTO;
import com.example.SwapShop.dto.IntercambiosPrestamosDTO;
import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.exception.ElementoNoEncontradoException;
import com.example.SwapShop.exception.ResourceAlreadyExistsException;
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

import java.time.LocalDate;
import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UsuarioServiceTests {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Autowired
    private IntercambiosPrestamosService intercambiosPrestamosService;

    @Autowired
    private IIntercambiosPrestamosRepository intercambiosPrestamosRepository;

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

//        IntercambiosPrestamos intercambio1 = new IntercambiosPrestamos();
//        intercambio1.setEstado(EstadoIntercambio.ACEPTADO);
//        intercambio1.setTipo(TipoIntercambio.INTERCAMBIO);
//        intercambio1.setFechaInicio(Date.valueOf(LocalDate.now()));
//        intercambio1.setFechaFin(Date.valueOf(LocalDate.now().plusDays(7)));
//        intercambio1.setDueno(usuario1);
//        intercambio1.setSolicitante(usuario2);
//        intercambio1.setPrenda(prenda1);
//        intercambio1.setPrenda2(prenda2);
//
//        IntercambiosPrestamos intercambio2 = new IntercambiosPrestamos();
//        intercambio2.setEstado(EstadoIntercambio.ACEPTADO);
//        intercambio2.setTipo(TipoIntercambio.INTERCAMBIO);
//        intercambio2.setFechaInicio(Date.valueOf(LocalDate.now()));
//        intercambio2.setFechaFin(Date.valueOf(LocalDate.now().plusDays(7)));
//        intercambio2.setDueno(usuario1);
//        intercambio2.setSolicitante(usuario2);
//        intercambio2.setPrenda(prenda1);
//        intercambio2.setPrenda2(prenda2);
//
//        intercambiosPrestamosRepository.save(intercambio1);
//        intercambiosPrestamosRepository.save(intercambio2);
    }

    @Test
    @DisplayName("Servicio 1 -> Caso Positivo")
    public void crearUsuarioTest() {

        //Given
        UsuarioDTO nuevoUsuarioDTO = new UsuarioDTO();
        nuevoUsuarioDTO.setNombreUsuario("usuario3");
        nuevoUsuarioDTO.setCorreo("correo3");
        nuevoUsuarioDTO.setContrasena("contrasena3");
        nuevoUsuarioDTO.setNombre("nombre3");
        nuevoUsuarioDTO.setApellido1("apellido3");
        nuevoUsuarioDTO.setApellido2("apellido3");
        nuevoUsuarioDTO.setFecha_nac(Date.valueOf(LocalDate.of(1990, 1, 1)));

        //When
        UsuarioDTO usuarioCreado = usuarioService.crearUsuario(nuevoUsuarioDTO);

        //Then
        assertNotNull(usuarioCreado, "El usuario creado no debería ser nulo.");
        assertNotNull(usuarioCreado.getId(), "El usuario creado debería tener un ID.");
        assertEquals("usuario3", usuarioCreado.getNombreUsuario(), "El nombre del usuario no coincide");
        assertEquals("correo3", usuarioCreado.getCorreo(), "El correo del usuario no coincide");
        assertEquals("contrasena3", usuarioCreado.getContrasena(), "La contraseña del usuario no coincide");
        assertEquals("nombre3", usuarioCreado.getNombre(), "El nombre del usuario no coincide");
        assertEquals("apellido3", usuarioCreado.getApellido1(), "El apellido1 del usuario no coincide");
        assertEquals("apellido3", usuarioCreado.getApellido2(), "El apellido2 del usuario no coincide");
        assertEquals(Date.valueOf(LocalDate.of(1990, 1, 1)), usuarioCreado.getFecha_nac(), "La fecha de nacimiento del usuario no coincide");
    }

    @Test
    @DisplayName("Servicio 1 -> Caso Negativo")
    public void crearUsuarioTetsNegativo() {

        //Given
        UsuarioDTO nuevoUsuarioDTO = new UsuarioDTO();
        nuevoUsuarioDTO.setNombreUsuario("usuario1");
        nuevoUsuarioDTO.setCorreo("correo1");
        nuevoUsuarioDTO.setContrasena("contrasena3");
        nuevoUsuarioDTO.setNombre("nombre3");
        nuevoUsuarioDTO.setApellido1("apellido3");
        nuevoUsuarioDTO.setApellido2("apellido3");
        nuevoUsuarioDTO.setFecha_nac(Date.valueOf(LocalDate.of(1990, 1, 1)));

        //When


        //Then
        assertThrows(ResourceAlreadyExistsException.class, () -> usuarioService.crearUsuario(nuevoUsuarioDTO));
    }

    @Test
    @DisplayName("Servicio 2 -> Caso Positivo")
    public void buscarUsuarioPorIdTest() {
        //Given

        //Then

        UsuarioDTO dto = usuarioService.buscarUsuarioPorId(1);

        //When
        assertNotNull(dto,"El usuario no existe o es nulo.");
        assertEquals(dto.getNombreUsuario(),"usuario1","El nombre del usuario no coincide");
    }

    @Test
    @DisplayName("Servicio 2 -> Caso Negativo")
    public void buscarUsuarioPorIdTestNegativo() {
        //Given

        //Then

        //When
        assertThrows(ElementoNoEncontradoException.class, () -> usuarioService.buscarUsuarioPorId(888));
    }

    @Test
    @DisplayName("Servicio 10 -> Caso Positivo")
    public void usuarioConMasIntercambiosTest() {
        //Given

        //Then

        EstadisticasUsuarioDTO usuarioDTO = usuarioService.usuarioConMasIntercambios();

        //When
        assertNotNull(usuarioDTO, "No existen usuarios con intercambios aceptados.");
    }

    @Test
    @DisplayName("Servicio 10 -> Caso Negativo")
    public void usuarioConMasIntercambiosTestNegativo() {
        //Given

        //Then

        //When
        assertThrows(ElementoNoEncontradoException.class, () -> usuarioService.usuarioConMasIntercambios());
    }
}
