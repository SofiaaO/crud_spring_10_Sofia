package com.so.crud.controllers;

import com.so.crud.domain.dto.CategoriaDto;
import com.so.crud.domain.entities.CategoriaEntity;
import com.so.crud.mappers.impl.CategoriaMapper;
import com.so.crud.services.CategoriaService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;
    private final CategoriaMapper categoriaMapper;

    public CategoriaController(CategoriaService categoriaService, CategoriaMapper categoriaMapper) {
        this.categoriaService = categoriaService;
        this.categoriaMapper = categoriaMapper;
    }

    @PostMapping
    public CategoriaDto crearCategoria(@RequestBody CategoriaDto categoriaDto) {
        CategoriaEntity categoriaEntity = categoriaMapper.mapFrom(categoriaDto);
        CategoriaEntity categoriaCreada = categoriaService.crearCategoria(categoriaEntity);
        return categoriaMapper.mapTo(categoriaCreada);
    }

    @GetMapping("/{id}")
    public CategoriaDto obtenerCategoria(@PathVariable Long id) {
        CategoriaEntity categoriaEntity = categoriaService.obtenerCategoria(id);
        return categoriaMapper.mapTo(categoriaEntity);
    }

    @GetMapping
    public List<CategoriaDto> obtenerTodasCategorias() {
        List<CategoriaEntity> categorias = categoriaService.obtenerTodasCategorias();
        return categorias.stream()
                .map(categoriaMapper::mapTo)
                .toList();
    }

    @PutMapping("/{id}")
    public CategoriaDto actualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDto categoriaDto) {
        CategoriaEntity categoriaEntity = categoriaMapper.mapFrom(categoriaDto);
        categoriaEntity.setId(id);
        CategoriaEntity categoriaActualizada = categoriaService.actualizarCategoria(categoriaEntity);
        return categoriaMapper.mapTo(categoriaActualizada);
    }

    @DeleteMapping("/{id}")
    public void eliminarCategoria(@PathVariable Long id) {
        categoriaService.eliminarCategoria(id);
    }
}
