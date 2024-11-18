package com.example.clinica.domain.repository;

import com.example.clinica.infrastructure.persistence.entity.EspecialidadeModel;

import java.util.Optional;

public interface IEspecialidadeRepository {

    EspecialidadeModel save(EspecialidadeModel especialidadeModel);

    Optional<EspecialidadeModel> findById(Integer id);

    Iterable<EspecialidadeModel> findAll();

    void deleteById(Integer id);

    Boolean existsById(Integer id);
}
