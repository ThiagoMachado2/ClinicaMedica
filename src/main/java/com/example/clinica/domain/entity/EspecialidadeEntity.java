package com.example.clinica.domain.entity;

import com.example.clinica.adapter.model.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EspecialidadeEntity implements BaseEntity {

    private Integer id;
    private String nome;               // Nome da especialidade, ex: Cardiologia, Dermatologia

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
