package com.example.clinica.infrastructure.persistence.repository.jpa;


import com.example.clinica.infrastructure.persistence.entity.PacienteModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPacienteModelRepository extends JpaRepository<PacienteModel, Integer> {
}
