package com.example.SwapShop.repositorios;

import com.example.SwapShop.modelos.Valoraciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IValoracionesRepository extends JpaRepository<Valoraciones, Integer> {
}
