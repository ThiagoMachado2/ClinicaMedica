package com.example.clinica.infrastructure.persistence.repository.impl;


import com.example.clinica.domain.repository.IPacienteRepository;
import com.example.clinica.infrastructure.persistence.entity.PacienteModel;
import com.example.clinica.infrastructure.persistence.repository.jpa.IPacienteModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PacienteRepositoryImplementation implements IPacienteRepository {

    @Autowired
    private IPacienteModelRepository pacienteModelRepository;

    @Override
    @Transactional
    public PacienteModel save(PacienteModel pacienteModel) {
        return pacienteModelRepository.save(pacienteModel);
    }

    @Override
    @Transactional
    public Optional<PacienteModel> findById(Integer id) {
        return pacienteModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<PacienteModel> findAll() {
        return pacienteModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        pacienteModelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean existsById(Integer id) {
        return pacienteModelRepository.existsById(id);
    }
}
