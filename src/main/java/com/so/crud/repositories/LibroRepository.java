package com.so.crud.repositories;

import com.so.crud.domain.entities.LibroEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface LibroRepository extends CrudRepository<LibroEntity, Long> {
    List<LibroEntity> findAll();
}
