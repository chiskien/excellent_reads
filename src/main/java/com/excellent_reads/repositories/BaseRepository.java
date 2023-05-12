package com.excellent_reads.repositories;

import java.util.List;
import java.util.Optional;

public interface BaseRepository<T> {

    List<T> getAll();

    Optional<T> getById(Long id);

    void delete(Long id);

    T save(T entity);

}
