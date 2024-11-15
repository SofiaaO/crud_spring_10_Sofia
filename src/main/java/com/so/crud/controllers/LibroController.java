package com.so.crud.controllers;

import com.so.crud.domain.dto.LibroDto;
import com.so.crud.domain.entities.LibroEntity;
import com.so.crud.mappers.impl.LibroMapper;
import com.so.crud.services.LibroService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    private final LibroService libroService;
    private final LibroMapper libroMapper;

    public LibroController(LibroService libroService, LibroMapper libroMapper) {
        this.libroService = libroService;
        this.libroMapper = libroMapper;
    }

    @PostMapping
    public LibroDto crearLibro(@RequestBody LibroDto libroDto) {
        LibroEntity libroEntity = libroMapper.mapFrom(libroDto);
        LibroEntity libroCreado = libroService.crearLibro(libroEntity);
        return libroMapper.mapTo(libroCreado);
    }

    @GetMapping("/{id}")
    public LibroDto obtenerLibro(@PathVariable Long id) {
        LibroEntity libroEntity = libroService.obtenerLibro(id);
        return libroMapper.mapTo(libroEntity);
    }

    @GetMapping
    public List<LibroDto> obtenerTodosLibros() {
        List<LibroEntity> libros = libroService.obtenerTodosLibros();
        return libros.stream()
                .map(libroMapper::mapTo)
                .toList();
    }

    @PutMapping("/{id}")
    public LibroDto actualizarLibro(@PathVariable Long id, @RequestBody LibroDto libroDto) {
        LibroEntity libroEntity = libroMapper.mapFrom(libroDto);
        libroEntity.setId(id);
        LibroEntity libroActualizado = libroService.actualizarLibro(libroEntity);
        return libroMapper.mapTo(libroActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarLibro(@PathVariable Long id) {
        libroService.eliminarLibro(id);
    }
}
