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
public class AutorDto {
    private Long id;
    private String nombre;
    private String nacionalidad;
    private Set<LibroDto> libros;
}
