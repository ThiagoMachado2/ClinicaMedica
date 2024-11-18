package com.example.clinica.domain.entity;

import com.example.clinica.adapter.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ConsultaEntity implements BaseEntity {

    private Integer id;
    private LocalDateTime dataHora;
    private Integer medicoId;          // ID do médico responsável pela consulta
    private Integer pacienteId;        // ID do paciente que irá realizar a consulta
    private Integer especialidadeId;   // ID da especialidade da consulta


    @Override
    public int getId() {
        return 0;
    }

    @Override
    public void setId(int id) {

    }
}