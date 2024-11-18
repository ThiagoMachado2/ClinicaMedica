package com.example.clinica.application.service;


import com.example.clinica.adapter.dto.MedicoDTO;
import com.example.clinica.domain.repository.IMedicoRepository;
import com.example.clinica.infrastructure.persistence.entity.MedicoModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class MedicoService {

    @Autowired
    private IMedicoRepository medicoRepository;

    @Autowired
    private ObjectMapperService objectMapperService;

    public void cadastrarMedico(MedicoDTO medicoDTO) {
        MedicoModel medicoModel = objectMapperService.toModelMedico(medicoDTO);
        medicoRepository.save(medicoModel);
    }

    public Optional<MedicoDTO> consultarPorId(int id) {
        Optional<MedicoModel> medico = medicoRepository.findById(id);
        return medico.map(medicoModel -> objectMapperService.toDtoMedico(medicoModel));
    }

    public List<MedicoDTO> listarMedicos() {
        Iterable<MedicoModel> medicos = medicoRepository.findAll();
        return StreamSupport.stream(medicos.spliterator(), false)
                .map(medicoModel -> objectMapperService.toDtoMedico(medicoModel))
                .collect(Collectors.toList());
    }

    public void atualizarMedico(MedicoDTO medicoDTO) {
        MedicoModel existingMedico = medicoRepository.findById(medicoDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Médico não encontrado"));
        MedicoModel updatedMedico = objectMapperService.toModelMedico(medicoDTO);
        medicoRepository.save(updatedMedico);
    }

    public void excluirMedico(int id) {
        medicoRepository.deleteById(id);
    }

    public Boolean existePorId(int medicoId) {
        return medicoRepository.existsById(medicoId);
    }
}

