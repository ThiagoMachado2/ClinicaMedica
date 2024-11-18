package com.example.clinica.domain.repository;

import com.example.clinica.infrastructure.persistence.entity.ConsultaModel;

import java.util.Optional;

public interface IConsultaRepository {
    ConsultaModel save(ConsultaModel consultaModel);

    Optional<ConsultaModel> findById(Integer id);

    Iterable<ConsultaModel> findAll();

    void deleteById(Integer id);

    Boolean existsById(Integer id);
}
