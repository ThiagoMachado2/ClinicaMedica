package com.example.clinica.adapter.mapper;

import com.example.clinica.adapter.dto.*;
import com.example.clinica.adapter.mapper.utils.CycleAvoidingMappingContext;
import com.example.clinica.domain.entity.*;
import com.example.clinica.infrastructure.persistence.entity.*;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring")
public interface MapStructMapper {

    // CONSULTA MAPPING
    //ConsultaDTO entityToDto(ConsultaEntity consultaEntity, @Context CycleAvoidingMappingContext context);
    ConsultaEntity dtoToEntity(ConsultaDTO consultaDTO, @Context CycleAvoidingMappingContext context);
    // ConsultaModel entityToModel(ConsultaEntity consultaEntity, @Context CycleAvoidingMappingContext context);
    ConsultaEntity modelToEntity(ConsultaModel consultaModel, @Context CycleAvoidingMappingContext context);
    ConsultaDTO modelToDto(ConsultaModel consultaModel, @Context CycleAvoidingMappingContext context);
    ConsultaModel dtoToModel(ConsultaDTO consultaDTO, @Context CycleAvoidingMappingContext context);

    // MÉDICO MAPPING
   // MedicoDTO entityToDto(MedicoEntity medicoEntity, @Context CycleAvoidingMappingContext context);
    MedicoEntity dtoToEntity(MedicoDTO medicoDTO, @Context CycleAvoidingMappingContext context);
    // MedicoModel entityToModel(MedicoEntity medicoEntity, @Context CycleAvoidingMappingContext context);
    // MedicoEntity modelToEntity(MedicoModel medicoModel, @Context CycleAvoidingMappingContext context);
    MedicoDTO modelToDto(MedicoModel medicoModel, @Context CycleAvoidingMappingContext context);
    MedicoModel dtoToModel(MedicoDTO medicoDTO, @Context CycleAvoidingMappingContext context);

    // PACIENTE MAPPING
   // PacienteDTO entityToDto(PacienteEntity pacienteEntity, @Context CycleAvoidingMappingContext context);
    PacienteEntity dtoToEntity(PacienteDTO pacienteDTO, @Context CycleAvoidingMappingContext context);
   // PacienteModel entityToModel(PacienteEntity pacienteEntity, @Context CycleAvoidingMappingContext context);
   // PacienteEntity modelToEntity(PacienteModel pacienteModel, @Context CycleAvoidingMappingContext context);
    PacienteDTO modelToDto(PacienteModel pacienteModel, @Context CycleAvoidingMappingContext context);
    PacienteModel dtoToModel(PacienteDTO pacienteDTO, @Context CycleAvoidingMappingContext context);

    // ESPECIALIDADE MAPPING
    //EspecialidadeDTO entityToDto(EspecialidadeEntity especialidadeEntity, @Context CycleAvoidingMappingContext context);
    EspecialidadeEntity dtoToEntity(EspecialidadeDTO especialidadeDTO, @Context CycleAvoidingMappingContext context);
   // EspecialidadeModel entityToModel(EspecialidadeEntity especialidadeEntity, @Context CycleAvoidingMappingContext context);
//EspecialidadeEntity modelToEntity(EspecialidadeModel especialidadeModel, @Context CycleAvoidingMappingContext context);
    EspecialidadeDTO modelToDto(EspecialidadeModel especialidadeModel, @Context CycleAvoidingMappingContext context);
    EspecialidadeModel dtoToModel(EspecialidadeDTO especialidadeDTO, @Context CycleAvoidingMappingContext context);
    String especialidadeToString(EspecialidadeModel especialidade);
    EspecialidadeModel stringToEspecialidade(String especialidade);

    // RECEPCIONISTA MAPPING
    //RecepcionistaDTO entityToDto(RecepcionistaEntity recepcionistaEntity, @Context CycleAvoidingMappingContext context);
    // dtoToEntity(RecepcionistaDTO recepcionistaDTO, @Context CycleAvoidingMappingContext context);
    //RecepcionistaModel entityToModel(RecepcionistaEntity recepcionistaEntity, @Context CycleAvoidingMappingContext context);
    // modelToEntity(RecepcionistaModel recepcionistaModel, @Context CycleAvoidingMappingContext context);
    RecepcionistaDTO modelToDto(RecepcionistaModel recepcionistaModel, @Context CycleAvoidingMappingContext context);
    RecepcionistaModel dtoToModel(RecepcionistaDTO recepcionistaDTO, @Context CycleAvoidingMappingContext context);



}
