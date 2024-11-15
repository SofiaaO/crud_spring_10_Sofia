package com.so.crud.repositories;

import com.so.crud.domain.entities.AutorEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends CrudRepository<AutorEntity, Long> {
}