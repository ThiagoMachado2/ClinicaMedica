package com.example.clinica.adapter.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RecepcionistaDTO {

    private Integer id;
    private String nome;
    private String cpf;
    private String telefone;
    private String email;
    private LocalDate dataContratacao;
    private String endereco;

}
