package com.so.crud.domain.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "autores")
public class AutorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "autor_id_seq")
    private Long id;

    private String nombre;

    private String nacionalidad;

    @ManyToMany(mappedBy = "autores", cascade = CascadeType.ALL)
    private Set<LibroEntity> libros = new HashSet<>();
}
