package com.so.crud.repositories;

import com.so.crud.domain.entities.CategoriaEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoriaRepository extends CrudRepository<CategoriaEntity, Long> {
}