package com.example.clinica.domain.repository;

import com.example.clinica.infrastructure.persistence.entity.PacienteModel;

import java.util.Optional;

public interface IPacienteRepository {

    PacienteModel save(PacienteModel pacienteModel);

    Optional<PacienteModel> findById(Integer id);

    Iterable<PacienteModel> findAll();

    void deleteById(Integer id);

    Boolean existsById(Integer id);
}
