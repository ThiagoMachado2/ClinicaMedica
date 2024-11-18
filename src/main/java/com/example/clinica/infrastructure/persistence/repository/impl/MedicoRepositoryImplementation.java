package com.example.clinica.infrastructure.persistence.repository.impl;


import com.example.clinica.domain.repository.IMedicoRepository;
import com.example.clinica.infrastructure.persistence.entity.MedicoModel;
import com.example.clinica.infrastructure.persistence.repository.jpa.IMedicoModelRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MedicoRepositoryImplementation implements IMedicoRepository {

    @Autowired
    private IMedicoModelRepository medicoModelRepository;

    @Override
    @Transactional
    public MedicoModel save(MedicoModel medicoModel) {
        return medicoModelRepository.save(medicoModel);
    }

    @Override
    @Transactional
    public Optional<MedicoModel> findById(Integer id) {
        return medicoModelRepository.findById(id);
    }

    @Override
    @Transactional
    public Iterable<MedicoModel> findAll() {
        return medicoModelRepository.findAll();
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        medicoModelRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Boolean existsById(Integer id) {
        return medicoModelRepository.existsById(id);
    }
}
