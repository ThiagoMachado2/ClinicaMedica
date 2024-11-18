package com.example.clinica.application.service;

import com.example.clinica.adapter.dto.RecepcionistaDTO;
import com.example.clinica.domain.repository.IRecepcionistaRepository;
import com.example.clinica.infrastructure.persistence.entity.RecepcionistaModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RecepcionistaService {

    @Autowired
    private IRecepcionistaRepository recepcionistaRepository;

    @Autowired
    private ObjectMapperService objectMapperService;


    public void cadastrarRecepcionista(RecepcionistaDTO recepcionistaDTO) {
        RecepcionistaModel recepcionistaModel = objectMapperService.toModelRecepcionista(recepcionistaDTO);
        recepcionistaRepository.save(recepcionistaModel);
    }

    public Optional<RecepcionistaDTO> consultarPorId(int id) {
        Optional<RecepcionistaModel> recepcionista = recepcionistaRepository.findById(id);
        return recepcionista.map(recepcionistaModel -> objectMapperService.toDtoRecepcionista(recepcionistaModel));
    }

    public List<RecepcionistaDTO> listarRecepcionistas() {
        Iterable<RecepcionistaModel> recepcionistas = recepcionistaRepository.findAll();
        return StreamSupport.stream(recepcionistas.spliterator(), false)
                .map(recepcionistaModel -> objectMapperService.toDtoRecepcionista(recepcionistaModel))
                .collect(Collectors.toList());
    }


    public void atualizarRecepcionista(RecepcionistaDTO recepcionistaDTO) {
        RecepcionistaModel existingRecepcionista = recepcionistaRepository.findById(recepcionistaDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Recepcionista não encontrado"));
        RecepcionistaModel updatedRecepcionista = objectMapperService.toModelRecepcionista(recepcionistaDTO);
        recepcionistaRepository.save(updatedRecepcionista);
    }

    public void excluirRecepcionista(int id) {
        recepcionistaRepository.deleteById(id);
    }

    public Boolean existePorId(int recepcionistaId) {
        return recepcionistaRepository.existsById(recepcionistaId);
    }
}

