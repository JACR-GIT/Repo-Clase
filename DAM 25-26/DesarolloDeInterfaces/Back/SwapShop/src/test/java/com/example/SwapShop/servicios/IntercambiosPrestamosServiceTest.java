package com.example.SwapShop.servicios;

import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
@Transactional
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class IntercambiosPrestamosServiceTest {

    @Test
    @DisplayName("Servicio 6 -> Caso Positivo")
    void crearIntercambioPrestamo() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 6 -> Caso Negativo")
    void crearIntercambioPrestamoNegativo() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 7 -> Caso Positivo")
    void cambiarEstado() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 7 -> Caso Negativo")
    void cambiarEstadoNegativo() {
        //Given

        //Then

        //When

    }

}
