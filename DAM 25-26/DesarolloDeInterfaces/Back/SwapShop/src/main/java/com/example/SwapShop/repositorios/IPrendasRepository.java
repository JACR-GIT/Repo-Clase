package com.example.SwapShop.repositorios;

import com.example.SwapShop.modelos.Prendas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPrendasRepository extends JpaRepository<Prendas, Integer> {
    Prendas findByTalla(String talla);
    Integer id(int id);
}
