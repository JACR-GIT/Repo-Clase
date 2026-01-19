package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.exception.ElementoNoEncontradoException;
import com.example.SwapShop.exception.ResourceAlreadyExistsException;
import com.example.SwapShop.modelos.Usuario;
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
import java.sql.Date; // Usar java.sql.Date para la conversión de LocalDate

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


    @BeforeAll
    void cargarDatos(){
        Usuario usuario1 = new Usuario();
        usuario1.setNombreUsuario("usuario1");
        usuario1.setCorreo("correo1");
        usuario1.setContrasena("contrasena1");
        usuario1.setNombre("nombre1");
        usuario1.setApellido1("apellido1");
        usuario1.setApellido2("apellido2");
        usuario1.setFecha_nac(Date.valueOf(LocalDate.of(1990, 1, 1))); // Corregido el formato de fecha

        Usuario usuario2 = new Usuario();
        usuario2.setNombreUsuario("usuario2");
        usuario2.setCorreo("correo2");
        usuario2.setContrasena("contrasena1");
        usuario2.setNombre("nombre1");
        usuario2.setApellido1("apellido1");
        usuario2.setApellido2("apellido2");
        usuario2.setFecha_nac(Date.valueOf(LocalDate.of(1990, 1, 1))); // Corregido el formato de fecha

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);

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
        nuevoUsuarioDTO.setNombreUsuario("usuario3");
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

        //When
    }

    @Test
    @DisplayName("Servicio 10 -> Caso Negativo")
    public void usuarioConMasIntercambiosTestNegativo() {
        //Given

        //Then

        //When
    }
}
