package com.example.clinica.adapter.mapper.utils;

import com.example.clinica.adapter.model.BaseEntity;
import com.example.clinica.adapter.model.BaseModel;
import org.mapstruct.Context;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class MapperUtils {

    @Named("entitiesToIntegers")
    public static <T extends BaseEntity> Set<Integer> mapEntitiesToIntegers(Set<T> entities) {
        return (entities == null) ? null : entities.stream()
                .map(BaseEntity::getId)
                .collect(Collectors.toSet());
    }

    @Named("integersToEntities")
    public static <T extends BaseEntity> Set<T> mapIntegersToEntities(Set<Integer> ids, Class<T> clazz, CycleAvoidingMappingContext context) {
        return (ids == null) ? null : ids.stream()
                .map(id -> {
                    try {
                        T entity = clazz.getDeclaredConstructor().newInstance();
                        entity.setId(id);
                        return entity;
                    } catch (Exception e) {
                        throw new RuntimeException("Error instantiating entity", e);
                    }
                }).collect(Collectors.toSet());
    }

    @Named("modelsToIntegers")
    public static <T extends BaseModel> Set<Integer> mapModelsToIntegers(Set<T> models) {
        return (models == null) ? null : models.stream()
                .map(BaseModel::getId)
                .collect(Collectors.toSet());
    }

    @Named("integersToModels")
    public static <T extends BaseModel> Set<T> mapIntegersToModels(Set<Integer> ids, Class<T> clazz, @Context CycleAvoidingMappingContext context) {
        return (ids == null) ? null : ids.stream().map(id -> mapIntegerToModel(id, clazz, context)).collect(Collectors.toSet());
    }

    @Named("integerToEntity")
    public static <T extends BaseEntity> T mapIntegerToEntity(Integer id, Class<T> clazz, @Context CycleAvoidingMappingContext context) {
        if (id == null) {
            return null;
        }
        try {
            T entity = clazz.getDeclaredConstructor().newInstance();
            entity.setId(id);
            return entity;
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating entity", e);
        }
    }

    @Named("integerToModel")
    public static <T extends BaseModel> T mapIntegerToModel(Integer id, Class<T> clazz, @Context CycleAvoidingMappingContext context) {
        if (id == null) {
            return null;
        }
        try {
            T model = clazz.getDeclaredConstructor().newInstance();
            model.setId(id);
            return model;
        } catch (Exception e) {
            throw new RuntimeException("Error instantiating model", e);
        }
    }
}
