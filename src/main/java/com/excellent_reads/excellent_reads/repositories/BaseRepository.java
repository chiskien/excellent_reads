package com.excellent_reads.excellent_reads.repositories;

import java.util.Optional;

public interface BaseRepository<T> {

    Iterable<T> getAll();

    Optional<T> getById(Long id);

    void delete(Long id);

    T save(T entity);

}
