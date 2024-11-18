package com.example.clinica.infrastructure.persistence.entity;

import com.example.clinica.adapter.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "medicos")
public class MedicoModel implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false, length = 20)
    private String crm;

    @ManyToOne
    @JoinColumn(name = "especialidade_id", nullable = false)
    private EspecialidadeModel especialidade;

    @Column(length = 15)
    private String telefone;

    @Column(length = 50)
    private String email;

    // Implementações dos métodos da interface BaseModel
    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
