package com.example.SwapShop.repositorios;

import com.example.SwapShop.dto.EstadisticasUsuarioDTO;
import com.example.SwapShop.dto.UsuarioDTO;
import com.example.SwapShop.modelos.Usuario;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Integer>{
     @Query(value = "SELECT \n" +
             "    u.id as id_usuario,\n" +
             "    u.nombre_usuario,\n" +
             "    u.nombre,\n" +
             "    u.apellido1,\n" +
             "    u.apellido2,\n" +
             "    COUNT(*) AS total_intercambios_aceptados\n" +
             "FROM usuarios u\n" +
             "JOIN intercambios i \n" +
             "    ON (i.id_dueno = u.id OR i.id_solicitante = u.id)\n" +
             "WHERE i.estado = 'aceptado'\n" +
             "GROUP BY u.id, u.nombre_usuario, u.nombre, u.apellido1, u.apellido2\n" +
             "ORDER BY total_intercambios_aceptados DESC\n" +
             "LIMIT 1;\n", nativeQuery = true)
     EstadisticasUsuarioDTO usuarioConMasIntercambios();
}
