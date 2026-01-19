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
public class PrendaServiceTest {

    @Test
    @DisplayName("Servicio 3 -> Caso Positivo")
    void crearPrenda() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 3 -> Caso Negativo")
    void crearPrendaNegativo() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 4 -> Caso Positivo")
    void buscarPrendaPorTalla() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 4 -> Caso Negativo")
    void buscarPrendaPorTallaNegativo() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 5 -> Caso Positivo")
    void modificarPrendaPorId() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 5 -> Caso Negativo")
    void modificarPrendaPorIdNegativo() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 9 -> Caso Positivo")
    void top5PrendasMasIntercambiadasAceptadas() {
        //Given

        //Then

        //When

    }

    @Test
    @DisplayName("Servicio 9 -> Caso Negativo")
    void top5PrendasMasIntercambiadasAceptadasNegativo() {
        //Given

        //Then

        //When

    }

}
