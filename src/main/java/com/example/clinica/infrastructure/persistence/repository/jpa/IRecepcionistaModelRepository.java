package com.example.clinica.infrastructure.persistence.repository.jpa;


import com.example.clinica.infrastructure.persistence.entity.RecepcionistaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRecepcionistaModelRepository extends JpaRepository<RecepcionistaModel, Integer> {
}
