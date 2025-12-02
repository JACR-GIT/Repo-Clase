package com.example.SwapShop.servicios;

import com.example.SwapShop.dto.PrendasDTO;
import com.example.SwapShop.mapeadores.PrendasMapper;
import com.example.SwapShop.modelos.Prendas;
import com.example.SwapShop.repositorios.IIntercambiosPrestamosRepository;
import com.example.SwapShop.repositorios.IPrendasRepository;
import lombok.AllArgsConstructor;
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
        Prendas prenda = prendasMapper.toEntity(prendasDTO);
        Prendas prendaGuardada = prendasRepository.save(prenda);
        return prendasMapper.toDTO(prendaGuardada);
    }

    public PrendasDTO buscarPrendaPorTalla (PrendasDTO prendasDTO) {
        Prendas prenda = prendasMapper.toEntity(prendasDTO);
        Prendas prendaBuscada = prendasRepository.findByTalla(prenda.getTalla());
        return prendasMapper.toDTO(prendaBuscada);
    }

    public PrendasDTO modificarPrendaPorId (PrendasDTO prendasDTO) {
        Prendas prenda = prendasRepository.findById(prendasDTO.getId())
                .orElseThrow(() -> new NoSuchElementException("Prenda no encontrada con id: " + prendasDTO.getId()));

        if (prenda != null) {
            prendasDTO.setNombre_prenda(prendasDTO.getNombre_prenda());
            prendasDTO.setTalla(prendasDTO.getTalla());
            prendasDTO.setCategoria(prendasDTO.getCategoria());
            prendasDTO.setCondicion(prendasDTO.getCondicion());
            prendasDTO.setDescripcion(prendasDTO.getDescripcion());
            prendasDTO.setDisponible(prendasDTO.getDisponible());
            prendasDTO.setId(prendasDTO.getId());
            prendasDTO.setId_dueno(prendasDTO.getId_dueno());

            prendasRepository.save(prenda);
        }
        return prendasMapper.toDTO(prenda);
    }

    public List<PrendasDTO> top5PrendasMasIntercambiadasAceptadas() {
        List<Prendas> prendasMasIntercambiadas = intercambiosPrestamosRepository.buscarTop5Intercambio();
        return prendasMapper.listToDTOs(prendasMasIntercambiadas);
    }
}
