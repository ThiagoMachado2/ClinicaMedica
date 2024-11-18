package com.example.clinica.domain.entity;

import com.example.clinica.adapter.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicoEntity implements BaseEntity {

    private Integer id;
    private String nome;
    private String crm;                 // Número de registro do médico
    private Integer especialidadeId;    // ID da especialidade do médico

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
