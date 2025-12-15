package com.example.SwapShop.repositorios;

import com.example.SwapShop.dto.EstadisticasUsuarioDTO;
import com.example.SwapShop.modelos.EstadoIntercambio;
import com.example.SwapShop.modelos.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

    @Query("SELECT new com.example.SwapShop.dto.EstadisticasUsuarioDTO(u.id, u.nombreUsuario, u.nombre, u.apellido1, u.apellido2, COUNT(i)) " +
           "FROM Usuario u JOIN IntercambiosPrestamos i ON (i.dueno.id = u.id OR i.solicitante.id = u.id) " +
           "WHERE i.estado = :estado " +
           "GROUP BY u.id, u.nombreUsuario, u.nombre, u.apellido1, u.apellido2 " +
           "ORDER BY COUNT(i) DESC")
    List<EstadisticasUsuarioDTO> findUsuarioConMasIntercambios(@Param("estado") EstadoIntercambio estado, Pageable pageable);

    Optional<Usuario> findByNombreUsuario(String nombreUsuario);

    Optional<Usuario> findByCorreo(String correo);
}
