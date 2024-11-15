package com.so.crud.services.impl;

import com.so.crud.domain.entities.CategoriaEntity;
import com.so.crud.repositories.CategoriaRepository;
import com.so.crud.services.CategoriaService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public CategoriaEntity crearCategoria(CategoriaEntity categoriaEntity) {
        return categoriaRepository.save(categoriaEntity);
    }

    @Override
    public CategoriaEntity obtenerCategoria(Long id) {
        return categoriaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Categoria no encontrada con ID: " + id));
    }

    @Override
    public List<CategoriaEntity> obtenerTodasCategorias() {
        return (List<CategoriaEntity>) categoriaRepository.findAll();
    }

    @Override
    public void eliminarCategoria(Long id) {
        categoriaRepository.deleteById(id);
    }

    @Override
    public CategoriaEntity actualizarCategoria(CategoriaEntity categoriaEntity) {
        return categoriaRepository.save(categoriaEntity);
    }
}
