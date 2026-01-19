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
public class VeloracionesServiceTest {

    @Test
    @DisplayName("Servicio 8 -> Caso Positivo")
    void crearValoracion() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 8 -> Caso Negativo")
    void crearValoracionNegativo() {
        //Given

        //Then

        //When

    }

}
