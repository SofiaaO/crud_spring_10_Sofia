package com.so.crud.controllers;

import com.so.crud.domain.dto.AutorDto;
import com.so.crud.domain.entities.AutorEntity;

import com.so.crud.services.AutorService;
import org.springframework.web.bind.annotation.*;
import com.so.crud.mappers.impl.AutorMapper;

import java.util.List;
@RestController
@RequestMapping("/api/autores")
public class AutorController {

    private final AutorService autorService;
    private final AutorMapper autorMapper;

    public AutorController(AutorService autorService, AutorMapper autorMapper) {
        this.autorService = autorService;
        this.autorMapper = autorMapper;
    }

    @PostMapping
    public AutorDto crearAutor(@RequestBody AutorDto autorDto) {
        AutorEntity autorEntity = autorMapper.mapFrom(autorDto);
        AutorEntity autorCreado = autorService.crearAutor(autorEntity);
        return autorMapper.mapTo(autorCreado);
    }

    @GetMapping("/{id}")
    public AutorDto obtenerAutor(@PathVariable Long id) {
        AutorEntity autorEntity = autorService.obtenerAutor(id);
        return autorMapper.mapTo(autorEntity);
    }

    @GetMapping
    public List<AutorDto> obtenerTodosAutores() {
        List<AutorEntity> autores = autorService.obtenerTodosAutores();
        return autores.stream()
                .map(autorMapper::mapTo)
                .toList();
    }

    @PutMapping("/{id}")
    public AutorDto actualizarAutor(@PathVariable Long id, @RequestBody AutorDto autorDto) {
        AutorEntity autorEntity = autorMapper.mapFrom(autorDto);
        autorEntity.setId(id);
        AutorEntity autorActualizado = autorService.actualizarAutor(autorEntity);
        return autorMapper.mapTo(autorActualizado);
    }

    @DeleteMapping("/{id}")
    public void eliminarAutor(@PathVariable Long id) {
        autorService.eliminarAutor(id);
    }
}
