package com.example.clinica.infrastructure.persistence.repository.impl;

import com.example.clinica.domain.repository.IConsultaRepository;
import com.example.clinica.infrastructure.persistence.entity.ConsultaModel;
import com.example.clinica.infrastructure.persistence.repository.jpa.IConsultaModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ConsultaRepositoryImplementation implements IConsultaRepository {

    @Autowired
    private IConsultaModelRepository consultaModelRepository;

    @Override
    @Transactional
    public ConsultaModel save(ConsultaModel consultaModel) {
        return consultaModelRepository.save(consultaModel);
    }

    @Override
    @Transactional
    public Optional<ConsultaModel> findById(Integer id) {
        return consultaModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<ConsultaModel> findAll() {
        return consultaModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        consultaModelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean existsById(Integer id) {
        return consultaModelRepository.existsById(id);
    }
}
