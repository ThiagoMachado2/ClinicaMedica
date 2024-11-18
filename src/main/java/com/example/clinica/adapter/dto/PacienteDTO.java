package com.example.clinica.adapter.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PacienteDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataNascimento;
    private String endereco;

}
