package com.excellent_reads.repositories;

import com.excellent_reads.models.Genre;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class GenreRepositoryTest {

    @Test
    void getAllGenres() {
        GenreRepository genreRepository = Mockito.mock(GenreRepository.class);
        Set<Genre> genreSet = genreRepository.getAllGenres();
        assertEquals(15, genreSet.size());
    }
}