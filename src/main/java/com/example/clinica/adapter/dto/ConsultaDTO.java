package com.example.clinica.adapter.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ConsultaDTO {

    private Integer id;
    private Integer pacienteId;
    private Integer medicoId;
    private LocalDateTime dataConsulta;
    private String descricao;

}
