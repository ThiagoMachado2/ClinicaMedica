package com.example.clinica.infrastructure.persistence.entity;

import com.example.clinica.adapter.model.BaseModel;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "pacientes")
public class PacienteModel implements BaseModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 100)
    private String nome;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Column(length = 15)
    private String telefone;

    @Column(length = 50)
    private String email;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}
