package com.so.crud.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LibroDto {
    private Long id;
    private String titulo;
    private Integer anoPublicacion;
    private Set<AutorDto> autores;
    private CategoriaDto categoria;
}