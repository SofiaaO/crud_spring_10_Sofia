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
@Table(name = "libros")
public class LibroEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "libro_id_seq")
    private Long id;

    private String titulo;

    private Integer anoPublicacion;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "libros_autores",
            joinColumns = @JoinColumn(name = "libro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<AutorEntity> autores = new HashSet<>();

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private CategoriaEntity categoria;
}
