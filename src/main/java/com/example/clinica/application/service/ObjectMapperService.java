package com.example.clinica.application.service;

import com.example.clinica.adapter.dto.*;
import com.example.clinica.adapter.mapper.*;
import com.example.clinica.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.example.clinica.domain.entity.*;
import com.example.clinica.infrastructure.persistence.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class ObjectMapperService {

    @Autowired
    private MapStructMapper mapStructMapper;

    @Autowired
    private CycleAvoidingMappingContext context;

    // MÉTODOS PARA CONSULTA
    public ConsultaDTO toDtoConsulta(ConsultaModel consultaModel) {
        if (consultaModel == null) {
            throw new IllegalArgumentException("ConsultaModel não pode ser nulo");
        }
        return mapStructMapper.modelToDto(consultaModel, context);
    }

    public ConsultaEntity toEntity(ConsultaDTO consultaDTO) {
        if (consultaDTO == null) {
            throw new IllegalArgumentException("ConsultaDTO não pode ser nulo");
        }
        return mapStructMapper.dtoToEntity(consultaDTO, context);
    }

    public ConsultaModel toModelConsulta(ConsultaDTO consultaDTO) {
        if (consultaDTO == null) {
            throw new IllegalArgumentException("ConsultaDTO não pode ser nulo");
        }
        return mapStructMapper.dtoToModel(consultaDTO, context);
    }

    public ConsultaEntity toEntity(ConsultaModel consultaModel) {
        if (consultaModel == null) {
            throw new IllegalArgumentException("ConsultaModel não pode ser nulo");
        }
        return mapStructMapper.modelToEntity(consultaModel, context);
    }

    // MÉTODOS PARA MÉDICO
    public MedicoDTO toDtoMedico(MedicoModel medicoModel) {
        if (medicoModel == null) {
            throw new IllegalArgumentException("MedicoModel não pode ser nulo");
        }
        return mapStructMapper.modelToDto(medicoModel, context);
    }


    public MedicoEntity toEntity(MedicoDTO medicoDTO) {
        if (medicoDTO == null) {
            throw new IllegalArgumentException("MedicoDTO não pode ser nulo");
        }
        return mapStructMapper.dtoToEntity(medicoDTO, context);
    }

    public MedicoModel toModelMedico(MedicoDTO medicoDTO) {
        if (medicoDTO == null) {
            throw new IllegalArgumentException("MedicoDTO não pode ser nulo");
        }
        return mapStructMapper.dtoToModel(medicoDTO, context);
    }

    // MÉTODOS PARA PACIENTE
    public PacienteDTO toDtoPaciente(PacienteModel pacienteModel) {
        if (pacienteModel == null) {
            throw new IllegalArgumentException("PacienteModel não pode ser nulo");
        }
        return mapStructMapper.modelToDto(pacienteModel, context);
    }


    public PacienteEntity toEntity(PacienteDTO pacienteDTO) {
        if (pacienteDTO == null) {
            throw new IllegalArgumentException("PacienteDTO não pode ser nulo");
        }
        return mapStructMapper.dtoToEntity(pacienteDTO, context);
    }

    public PacienteModel toModelPaciente(PacienteDTO pacienteDTO) {
        if (pacienteDTO == null) {
            throw new IllegalArgumentException("PacienteDTO não pode ser nulo");
        }
        return mapStructMapper.dtoToModel(pacienteDTO, context);
    }

    // MÉTODOS PARA ESPECIALIDADE
    public EspecialidadeDTO toDtoEspecialidade(EspecialidadeModel especialidadeModel) {
        if (especialidadeModel == null) {
            throw new IllegalArgumentException("EspecialidadeModel não pode ser nulo");
        }
        return mapStructMapper.modelToDto(especialidadeModel, context);
    }


    public EspecialidadeEntity toEntity(EspecialidadeDTO especialidadeDTO) {
        if (especialidadeDTO == null) {
            throw new IllegalArgumentException("EspecialidadeDTO não pode ser nulo");
        }
        return mapStructMapper.dtoToEntity(especialidadeDTO, context);
    }

    public EspecialidadeModel toModelEspecialidade(EspecialidadeDTO especialidadeDTO) {
        if (especialidadeDTO == null) {
            throw new IllegalArgumentException("EspecialidadeDTO não pode ser nulo");
        }
        return mapStructMapper.dtoToModel(especialidadeDTO, context);
    }

    // MÉTODOS PARA RECEPCIONISTA
    public RecepcionistaModel toModelRecepcionista(RecepcionistaDTO recepcionistaDTO) {
        if (recepcionistaDTO == null) {
            throw new IllegalArgumentException("RecepcionistaDTO não pode ser nulo");
        }
        return mapStructMapper.dtoToModel(recepcionistaDTO, context);
    }

    public RecepcionistaDTO toDtoRecepcionista(RecepcionistaModel recepcionistaModel) {
        if (recepcionistaModel == null) {
            throw new IllegalArgumentException("RecepcionistaModel não pode ser nulo");
        }
        return mapStructMapper.modelToDto(recepcionistaModel, context);
    }




}

