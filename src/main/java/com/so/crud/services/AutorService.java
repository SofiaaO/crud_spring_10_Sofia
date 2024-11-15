package com.so.crud.services;


import com.so.crud.domain.entities.AutorEntity;
import java.util.List;
public interface AutorService {
    AutorEntity crearAutor(AutorEntity autorEntity);
    AutorEntity obtenerAutor(Long id);
    List<AutorEntity> obtenerTodosAutores();
    void eliminarAutor(Long id);
    AutorEntity actualizarAutor(AutorEntity autorEntity);
}
