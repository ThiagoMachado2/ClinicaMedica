package com.example.clinica.application.service;

import com.example.clinica.adapter.dto.EspecialidadeDTO;
import com.example.clinica.domain.repository.IEspecialidadeRepository;
import com.example.clinica.infrastructure.persistence.entity.EspecialidadeModel;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class EspecialidadeService {

    @Autowired
    private IEspecialidadeRepository especialidadeRepository;

    @Autowired
    private ObjectMapperService objectMapperService;

    public void criarEspecialidade(EspecialidadeDTO especialidadeDTO) {
        EspecialidadeModel especialidadeModel = objectMapperService.toModelEspecialidade(especialidadeDTO);
        especialidadeRepository.save(especialidadeModel);
    }

    public Optional<EspecialidadeDTO> consultarPorId(int id) {
        Optional<EspecialidadeModel> especialidade = especialidadeRepository.findById(id);
        return especialidade.map(objectMapperService::toDtoEspecialidade);
    }

    public List<EspecialidadeDTO> listarEspecialidades() {
        Iterable<EspecialidadeModel> especialidades = especialidadeRepository.findAll();
        return StreamSupport.stream(especialidades.spliterator(), false)
                .map(objectMapperService::toDtoEspecialidade)
                .collect(Collectors.toList());
    }

    public void atualizarEspecialidade(EspecialidadeDTO especialidadeDTO) {
        EspecialidadeModel existingEspecialidade = especialidadeRepository.findById(especialidadeDTO.getId())
                .orElseThrow(() -> new EntityNotFoundException("Especialidade não encontrada"));
        EspecialidadeModel updatedEspecialidade = objectMapperService.toModelEspecialidade(especialidadeDTO);
        especialidadeRepository.save(updatedEspecialidade);
    }

    public void excluirEspecialidade(int id) {
        especialidadeRepository.deleteById(id);
    }

    public Boolean existePorId(int especialidadeId) {
        return especialidadeRepository.existsById(especialidadeId);
    }
}

