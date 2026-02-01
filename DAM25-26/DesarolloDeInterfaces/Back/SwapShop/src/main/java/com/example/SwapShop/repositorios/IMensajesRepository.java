package com.example.SwapShop.repositorios;

import com.example.SwapShop.modelos.Mensajes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMensajesRepository extends JpaRepository<Mensajes, Integer> {
}
