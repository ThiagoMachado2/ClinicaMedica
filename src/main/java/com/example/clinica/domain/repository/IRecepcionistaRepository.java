package com.example.clinica.domain.repository;

import com.example.clinica.infrastructure.persistence.entity.RecepcionistaModel;

import java.util.Optional;

public interface IRecepcionistaRepository {

    RecepcionistaModel save(RecepcionistaModel recepcionistaModel);

    Optional<RecepcionistaModel> findById(Integer id);

    Iterable<RecepcionistaModel> findAll();

    void deleteById(Integer id);

    Boolean existsById(Integer id);
}
