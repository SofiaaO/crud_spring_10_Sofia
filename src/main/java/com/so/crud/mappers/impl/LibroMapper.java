package com.so.crud.mappers.impl;

import com.so.crud.domain.dto.LibroDto;
import com.so.crud.domain.entities.LibroEntity;
import com.so.crud.mappers.Mapper;
import org.modelmapper.ModelMapper;
import com.so.crud.domain.entities.CategoriaEntity;
import com.so.crud.domain.entities.AutorEntity;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LibroMapper implements Mapper<LibroEntity, LibroDto> {

    private final ModelMapper modelMapper;

    public LibroMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.typeMap(LibroDto.class, LibroEntity.class).addMappings(mapper ->
                mapper.map(LibroDto::getAutores, LibroEntity::setAutores)
        );
    }

    @Override
    public LibroDto mapTo(LibroEntity libroEntity) {
        return modelMapper.map(libroEntity, LibroDto.class);
    }

    @Override
    public LibroEntity mapFrom(LibroDto libroDto) {
        LibroEntity libroEntity = modelMapper.map(libroDto, LibroEntity.class);

        Set<AutorEntity> autores = libroDto.getAutores().stream()
                .map(autorDto -> modelMapper.map(autorDto, AutorEntity.class))
                .collect(Collectors.toSet());
        libroEntity.setAutores(autores);

        CategoriaEntity categoria = modelMapper.map(libroDto.getCategoria(), CategoriaEntity.class);
        libroEntity.setCategoria(categoria);

        return libroEntity;
    }
}
