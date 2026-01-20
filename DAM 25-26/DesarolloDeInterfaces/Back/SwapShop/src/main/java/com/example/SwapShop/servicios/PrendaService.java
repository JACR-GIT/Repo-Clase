package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.EstadisticasPrendaDTO;
import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.mapeadores.PrendasMapper;
import com.example.SwapShop.modelos.Prendas;
import com.example.SwapShop.repositorios.IIntercambiosPrestamosRepository;
import com.example.SwapShop.repositorios.IPrendasRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import java.util.List;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@AllArgsConstructor
public class PrendaService {

    private IPrendasRepository prendasRepository;
    private IIntercambiosPrestamosRepository intercambiosPrestamosRepository;
    private PrendasMapper prendasMapper;

    public PrendasDTO crearPrenda(PrendasDTO prendasDTO) {
        if (prendasDTO == null) {
            throw new IllegalArgumentException("La prenda no puede ser nula");
        }
        if (prendasDTO.getNombrePrenda() == null || prendasDTO.getNombrePrenda().isEmpty()) {
            throw new IllegalArgumentException("El nombre de la prenda es obligatorio");
        }
        if (prendasDTO.getTalla() == null) {
            throw new IllegalArgumentException("La talla de la prenda es obligatoria");
        }
        if (prendasDTO.getCategoria() == null) {
            throw new IllegalArgumentException("La categoría de la prenda es obligatoria");
        }
        if (prendasDTO.getCondicion() == null) {
            throw new IllegalArgumentException("La condición de la prenda es obligatoria");
        }
        if (prendasDTO.getId_dueno() == null) {
            throw new IllegalArgumentException("El dueño de la prenda es obligatorio");
        }

        Prendas prenda = prendasMapper.toEntity(prendasDTO);
        Prendas prendaGuardada = prendasRepository.save(prenda);
        return prendasMapper.toDTO(prendaGuardada);
    }

    public List<PrendasDTO> buscarPrendaPorTalla (String talla) {
        List<Prendas> prendaBuscada = prendasRepository.buscarPorTalla(talla);
        return prendasMapper.listToDTOs(prendaBuscada);
    }

    public PrendasDTO modificarPrendaPorId (Integer id , PrendasDTO prendasDTO) {
        Prendas prenda = prendasRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Prenda no encontrada con id: " + id));

        prenda.setNombrePrenda(prendasDTO.getNombrePrenda());
        prenda.setTalla(prendasDTO.getTalla());
        prenda.setCategoria(prendasDTO.getCategoria());
        prenda.setCondicion(prendasDTO.getCondicion());
        prenda.setDescripcion(prendasDTO.getDescripcion());
        prenda.setDisponible(prendasDTO.getDisponible());

        Prendas prendaActualizada = prendasRepository.save(prenda);
        return prendasMapper.toDTO(prendaActualizada);
    }

    public List<EstadisticasPrendaDTO> top5PrendasMasIntercambiadasAceptadas() {
        Pageable top5 = PageRequest.of(0, 5);
        return intercambiosPrestamosRepository.buscarTop5Intercambio(top5);
    }

    public List<PrendasDTO> findAllPrendasWhenDisponible() {
        List<Prendas> prendasDisponibles = prendasRepository.findByDisponibleTrue();
        return prendasMapper.listToDTOs(prendasDisponibles);
    }

    public List<PrendasDTO> buscarPrendasPorDueno(Integer idDueno) {
        List<Prendas> prendas = prendasRepository.findByDuenoId(idDueno); // Llamada actualizada
        return prendasMapper.listToDTOs(prendas);
    }

    public void eliminarPrendaPorId(Integer id) {
        prendasRepository.deleteById(id);
    }

}
