package com.so.crud.mappers.impl;

import com.so.crud.domain.dto.AutorDto;
import com.so.crud.domain.entities.AutorEntity;
import com.so.crud.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AutorMapper implements Mapper<AutorEntity, AutorDto> {

    private final ModelMapper modelMapper;

    public AutorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AutorDto mapTo(AutorEntity autorEntity) {
        return modelMapper.map(autorEntity, AutorDto.class);
    }

    @Override
    public AutorEntity mapFrom(AutorDto autorDto) {
        return modelMapper.map(autorDto, AutorEntity.class);
    }
}