package com.so.crud.services;
import com.so.crud.domain.entities.CategoriaEntity;

import java.util.List;

public interface CategoriaService {
    CategoriaEntity crearCategoria(CategoriaEntity categoriaEntity);
    CategoriaEntity obtenerCategoria(Long id);
    List<CategoriaEntity> obtenerTodasCategorias();
    void eliminarCategoria(Long id);
    CategoriaEntity actualizarCategoria(CategoriaEntity categoriaEntity);
}