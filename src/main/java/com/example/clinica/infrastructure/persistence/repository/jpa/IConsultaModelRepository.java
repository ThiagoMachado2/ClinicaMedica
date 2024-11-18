package com.example.clinica.infrastructure.persistence.repository.jpa;

import com.example.clinica.infrastructure.persistence.entity.ConsultaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IConsultaModelRepository extends JpaRepository<ConsultaModel, Integer> {
}
