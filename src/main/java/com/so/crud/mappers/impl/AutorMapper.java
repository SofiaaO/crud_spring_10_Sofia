package com.so.crud.mappers.impl;

import com.so.crud.domain.dto.AutorDto;
import com.so.crud.domain.dto.LibroDto;
import com.so.crud.domain.entities.AutorEntity;
import com.so.crud.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class AutorMapper implements Mapper<AutorEntity, AutorDto> {

    private final ModelMapper modelMapper;

    public AutorMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public AutorDto mapTo(AutorEntity autorEntity) {
        AutorDto autorDto = modelMapper.map(autorEntity, AutorDto.class);

        Set<LibroDto> librosDto = (autorEntity.getLibros() != null ?
                autorEntity.getLibros().stream().map(libro -> modelMapper.map(libro, LibroDto.class)).collect(Collectors.toSet())
                : new HashSet<>());

        autorDto.setLibros(librosDto);
        return autorDto;
    }
    @Override
    public AutorEntity mapFrom(AutorDto autorDto) {
        return modelMapper.map(autorDto, AutorEntity.class);
    }
}
