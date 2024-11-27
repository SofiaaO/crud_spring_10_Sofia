package com.so.crud.services.impl;

import com.so.crud.domain.entities.AutorEntity;
import com.so.crud.domain.entities.CategoriaEntity;
import com.so.crud.domain.entities.LibroEntity;
import com.so.crud.repositories.LibroRepository;
import com.so.crud.services.AutorService;
import com.so.crud.services.CategoriaService;
import com.so.crud.services.LibroService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LibroServiceImpl implements LibroService {

    private final LibroRepository libroRepository;
    private final AutorService autorService;
    private final CategoriaService categoriaService;

    public LibroServiceImpl(LibroRepository libroRepository, AutorService autorService, CategoriaService categoriaService) {
        this.libroRepository = libroRepository;
        this.autorService = autorService;
        this.categoriaService = categoriaService;
    }

    @Override
    public LibroEntity crearLibro(LibroEntity libroEntity) {
        try {
            if (libroEntity.getAutores() != null && !libroEntity.getAutores().isEmpty()) {
                Set<AutorEntity> autores = libroEntity.getAutores().stream()
                        .map(autor -> autorService.obtenerAutor(autor.getId()))
                        .collect(Collectors.toSet());
                libroEntity.setAutores(autores);
            } else {
                throw new EntityNotFoundException("No se han proporcionado autores válidos.");
            }

            if (libroEntity.getCategoria() != null) {
                CategoriaEntity categoria = categoriaService.obtenerCategoria(libroEntity.getCategoria().getId());
                libroEntity.setCategoria(categoria);
            } else {
                throw new EntityNotFoundException("Categoría no válida proporcionada.");
            }

            return libroRepository.save(libroEntity);

        } catch (Exception e) {
            throw new RuntimeException("Error al crear el libro: " + e.getMessage(), e);
        }
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
