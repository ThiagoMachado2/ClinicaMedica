package com.example.clinica.adapter.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class MedicoDTO {

    private Integer id;
    private String nome;
    private String crm; // Registro do médico
    private String telefone;
    private String email;
    private LocalDate dataContratacao;
    private String especialidade; // Especialidade do médico
    private String endereco;

}
