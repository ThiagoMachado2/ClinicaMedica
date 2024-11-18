package com.example.clinica.infrastructure.persistence.repository.jpa;


import com.example.clinica.infrastructure.persistence.entity.MedicoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMedicoModelRepository extends JpaRepository<MedicoModel, Integer> {
}
