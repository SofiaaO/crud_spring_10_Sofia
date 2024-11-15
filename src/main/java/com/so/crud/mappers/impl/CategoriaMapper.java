package com.so.crud.mappers.impl;

import com.so.crud.domain.dto.CategoriaDto;
import com.so.crud.domain.entities.CategoriaEntity;
import com.so.crud.mappers.Mapper;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CategoriaMapper implements Mapper<CategoriaEntity, CategoriaDto> {

    private final ModelMapper modelMapper;

    public CategoriaMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoriaDto mapTo(CategoriaEntity categoriaEntity) {
        return modelMapper.map(categoriaEntity, CategoriaDto.class);
    }

    @Override
    public CategoriaEntity mapFrom(CategoriaDto categoriaDto) {
        return modelMapper.map(categoriaDto, CategoriaEntity.class);
    }
}
