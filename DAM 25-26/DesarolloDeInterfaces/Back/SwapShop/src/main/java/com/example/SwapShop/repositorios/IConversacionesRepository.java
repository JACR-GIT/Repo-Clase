package com.example.SwapShop.repositorios;

import com.example.SwapShop.modelos.Conversaciones;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConversacionesRepository extends JpaRepository<Conversaciones, Integer> {
}
