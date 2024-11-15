package com.so.crud.services.impl;

import com.so.crud.domain.entities.AutorEntity;
import com.so.crud.repositories.AutorRepository;
import com.so.crud.services.AutorService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorServiceImpl implements AutorService {

    private final AutorRepository autorRepository;

    public AutorServiceImpl(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @Override
    public AutorEntity crearAutor(AutorEntity autorEntity) {
        return autorRepository.save(autorEntity);
    }

    @Override
    public AutorEntity obtenerAutor(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Autor no encontrado con ID: " + id));
    }

    @Override
    public List<AutorEntity> obtenerTodosAutores() {
        return (List<AutorEntity>) autorRepository.findAll();
    }

    @Override
    public void eliminarAutor(Long id) {
        autorRepository.deleteById(id);
    }

    @Override
    public AutorEntity actualizarAutor(AutorEntity autorEntity) {
        return autorRepository.save(autorEntity);
    }
}

