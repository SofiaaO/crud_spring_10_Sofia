package com.so.crud.services;

import com.so.crud.domain.entities.LibroEntity;

import java.util.List;

public interface LibroService {
    LibroEntity crearLibro(LibroEntity libroEntity);
    LibroEntity obtenerLibro(Long id);
    List<LibroEntity> obtenerTodosLibros();
    LibroEntity actualizarLibro(LibroEntity libroEntity);
    void eliminarLibro(Long id);
}
