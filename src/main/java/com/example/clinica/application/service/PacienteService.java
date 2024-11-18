package com.example.clinica.application.service;

import com.example.clinica.adapter.dto.PacienteDTO;
import com.example.clinica.domain.repository.IPacienteRepository;
import com.example.clinica.infrastructure.persistence.entity.PacienteModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PacienteService {

    @Autowired
    private IPacienteRepository pacienteRepository;

    @Autowired
    private ObjectMapperService objectMapperService;

    public void cadastrarPaciente(PacienteDTO pacienteDTO) {
        PacienteModel pacienteModel = objectMapperService.toModelPaciente(pacienteDTO);
        pacienteRepository.save(pacienteModel);
    }

    public Optional<PacienteDTO> consultarPorId(int id) {
        Optional<PacienteModel> paciente = pacienteRepository.findById(id);
        return paciente.map(pacienteModel -> objectMapperService.toDtoPaciente(pacienteModel));
    }

    public List<PacienteDTO> listarPacientes() {
        Iterable<PacienteModel> pacientes = pacienteRepository.findAll();
        return StreamSupport.stream(pacientes.spliterator(), false)
                .map(pacienteModel -> objectMapperService.toDtoPaciente(pacienteModel))
                .collect(Collectors.toList());
    }

    public void atualizarPaciente(PacienteDTO pacienteDTO) {
        PacienteModel existingPaciente = pacienteRepository.findById(pacienteDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Paciente não encontrado"));
        PacienteModel updatedPaciente = objectMapperService.toModelPaciente(pacienteDTO);
        pacienteRepository.save(updatedPaciente);
    }

    public void excluirPaciente(int id) {
        pacienteRepository.deleteById(id);
    }

    public Boolean existePorId(int pacienteId) {
        return pacienteRepository.existsById(pacienteId);
    }
}

