package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.ValoracionesDTO;
import com.example.SwapShop.modelos.Usuario;
import com.example.SwapShop.repositorios.IUsuarioRepository;
import com.example.SwapShop.repositorios.IValoracionesRepository;
import jakarta.transaction.Transactional;
import org.h2.command.dml.MergeUsing;
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
public class VeloracionesServiceTest {

    @Autowired
    private ValoracionesServices valoracionesService;

    @Autowired
    private IValoracionesRepository valoracionesRepository;

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
        usuario2.setFecha_nac(Date.valueOf(LocalDate.of(1990, 1, 1)));

        usuarioRepository.save(usuario1);
        usuarioRepository.save(usuario2);
    }

    @Test
    @DisplayName("Servicio 8 -> Caso Positivo")
    void crearValoracionTest() {

        //Given
        ValoracionesDTO valoracionCreada = new ValoracionesDTO();
        valoracionCreada.setId(1);
        valoracionCreada.setValorador(1);
        valoracionCreada.setPuntuacion(5);

        //When

        ValoracionesDTO valoracionGuardada = valoracionesService.crearValoracion(1,valoracionCreada);

        //Then
        assertNotNull(valoracionGuardada, "La valoracion creada no debería ser nula.");
        assertNotNull(valoracionGuardada.getId(), "La valoracion creada debería tener un ID.");
    }

    @Test
    @DisplayName("Servicio 8 -> Caso Negativo")
    void crearValoracionNegativo() {

        //Given
        ValoracionesDTO valoracionCreada = new ValoracionesDTO();
        valoracionCreada.setPuntuacion(5);

        //Then

        //When
        assertThrows(IllegalArgumentException.class, () -> valoracionesService.crearValoracion(2, valoracionCreada));
    }

}
