package com.example.clinica.infrastructure.persistence.repository.impl;


import com.example.clinica.domain.repository.IEspecialidadeRepository;
import com.example.clinica.infrastructure.persistence.entity.EspecialidadeModel;
import com.example.clinica.infrastructure.persistence.repository.jpa.IEspecialidadeModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class EspecialidadeRepositoryImplementation implements IEspecialidadeRepository {

    @Autowired
    private IEspecialidadeModelRepository especialidadeModelRepository;

    @Override
    @Transactional
    public EspecialidadeModel save(EspecialidadeModel especialidadeModel) {
        return especialidadeModelRepository.save(especialidadeModel);
    }

    @Override
    @Transactional
    public Optional<EspecialidadeModel> findById(Integer id) {
        return especialidadeModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<EspecialidadeModel> findAll() {
        return especialidadeModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        especialidadeModelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean existsById(Integer id) {
        return especialidadeModelRepository.existsById(id);
    }
}
