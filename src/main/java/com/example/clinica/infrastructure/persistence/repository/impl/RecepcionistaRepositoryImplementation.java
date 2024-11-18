package com.example.clinica.infrastructure.persistence.repository.impl;

import com.example.clinica.domain.repository.IRecepcionistaRepository;
import com.example.clinica.infrastructure.persistence.entity.RecepcionistaModel;
import com.example.clinica.infrastructure.persistence.repository.jpa.IRecepcionistaModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class RecepcionistaRepositoryImplementation implements IRecepcionistaRepository {

    @Autowired
    private IRecepcionistaModelRepository recepcionistaModelRepository;

    @Override
    @Transactional
    public RecepcionistaModel save(RecepcionistaModel recepcionistaModel) {
        return recepcionistaModelRepository.save(recepcionistaModel);
    }

    @Override
    @Transactional
    public Optional<RecepcionistaModel> findById(Integer id) {
        return recepcionistaModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<RecepcionistaModel> findAll() {
        return recepcionistaModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        recepcionistaModelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean existsById(Integer id) {
        return recepcionistaModelRepository.existsById(id);
    }
}
