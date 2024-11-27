package com.so.crud.mappers.impl;

import com.so.crud.domain.dto.LibroDto;
import com.so.crud.domain.entities.LibroEntity;
import com.so.crud.mappers.Mapper;
import com.so.crud.services.AutorService;
import com.so.crud.services.CategoriaService;
import org.modelmapper.ModelMapper;
import com.so.crud.domain.entities.CategoriaEntity;
import com.so.crud.domain.entities.AutorEntity;
import org.springframework.stereotype.Component;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class LibroMapper implements Mapper<LibroEntity, LibroDto> {

    private final ModelMapper modelMapper;
    private final AutorService autorService;
    private final CategoriaService categoriaService;

    public LibroMapper(ModelMapper modelMapper, AutorService autorService, CategoriaService categoriaService) {
        this.modelMapper = modelMapper;
        this.autorService = autorService;
        this.categoriaService = categoriaService;

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

        if (libroDto.getAutores() != null) {
            Set<AutorEntity> autores = libroDto.getAutores().stream()
                    .map(autorDto -> autorService.obtenerAutor(autorDto.getId()))
                    .collect(Collectors.toSet());
            libroEntity.setAutores(autores);
        }

        if (libroDto.getCategoria() != null) {
            CategoriaEntity categoria = categoriaService.obtenerCategoria(libroDto.getCategoria().getId());
            libroEntity.setCategoria(categoria);
        }

        return libroEntity;
    }
}

