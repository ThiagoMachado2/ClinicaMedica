package com.example.clinica.domain.repository;

import com.example.clinica.infrastructure.persistence.entity.MedicoModel;

import java.util.Optional;

public interface IMedicoRepository {

    MedicoModel save(MedicoModel medicoModel);

    Optional<MedicoModel> findById(Integer id);

    Iterable<MedicoModel> findAll();

    void deleteById(Integer id);

    Boolean existsById(Integer id);
}
