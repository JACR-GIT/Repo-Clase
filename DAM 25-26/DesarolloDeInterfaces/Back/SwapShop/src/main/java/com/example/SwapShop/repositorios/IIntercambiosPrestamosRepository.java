package com.example.SwapShop.repositorios;

import com.example.SwapShop.modelos.IntercambiosPrestamos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IIntercambiosPrestamosRepository extends JpaRepository<IntercambiosPrestamos, Integer> {
}
