package com.excellent_reads.repositories;

import java.util.List;

public interface BaseRepository<T> {

    List<T> getAll();

    T getById(Long id);

    void delete(Long id);

    T save(T entity);
}
