package com.so.crud.services.impl;

import com.so.crud.domain.entities.LibroEntity;
import com.so.crud.repositories.LibroRepository;
import com.so.crud.services.LibroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;

    public LibroServiceImpl(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Override
    public LibroEntity crearLibro(LibroEntity libroEntity) {
        return libroRepository.save(libroEntity);
    }

    @Override
    public LibroEntity obtenerLibro(Long id) {
        return libroRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Libro no encontrado con ID: " + id));
    }

    @Override
    public List<LibroEntity> obtenerTodosLibros() {
        return libroRepository.findAll();
    }

    @Override
    public LibroEntity actualizarLibro(LibroEntity libroEntity) {
        return libroRepository.save(libroEntity);
    }

    @Override
    public void eliminarLibro(Long id) {
        libroRepository.deleteById(id);
    }
}
