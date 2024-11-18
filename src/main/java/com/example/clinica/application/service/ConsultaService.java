package com.example.clinica.application.service;

import com.example.clinica.adapter.dto.ConsultaDTO;
import com.example.clinica.domain.repository.IConsultaRepository;
import com.example.clinica.infrastructure.persistence.entity.ConsultaModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ConsultaService {

    @Autowired
    private IConsultaRepository consultaRepository;

    @Autowired
    private ObjectMapperService objectMapperService;

    public void agendarConsulta(ConsultaDTO consultaDTO) {
        ConsultaModel consultaModel = objectMapperService.toModelConsulta(consultaDTO);
        consultaRepository.save(consultaModel);
    }

    public Optional<ConsultaDTO> consultarPorId(int id) {
        Optional<ConsultaModel> consultaModel = consultaRepository.findById(id);
        return consultaModel.map(objectMapperService::toDtoConsulta); // Certifique-se de que toDtoConsulta aceita ConsultaModel
    }


    public List<ConsultaDTO> listarConsultas() {
        Iterable<ConsultaModel> consultas = consultaRepository.findAll();
        return StreamSupport.stream(consultas.spliterator(), false)
                .map(consultaModel -> objectMapperService.toDtoConsulta(consultaModel))
                .collect(Collectors.toList());
    }


    public void atualizarConsulta(ConsultaDTO consultaDTO) {
        ConsultaModel existingConsulta = consultaRepository.findById(consultaDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Consulta não encontrada"));
        ConsultaModel updatedConsulta = objectMapperService.toModelConsulta(consultaDTO);
        consultaRepository.save(updatedConsulta);
    }

    public void cancelarConsulta(int id) {
        consultaRepository.deleteById(id);
    }

    public Boolean existePorId(int consultaId) {
        return consultaRepository.existsById(consultaId);
    }
}

