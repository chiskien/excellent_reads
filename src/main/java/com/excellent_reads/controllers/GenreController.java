package com.excellent_reads.controllers;

import com.excellent_reads.models.Genre;
import com.excellent_reads.repositories.GenreRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GenreController {

    private final GenreRepository genreRepository;

    public GenreController(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    @GetMapping("/genres")
    public List<Genre> getAllGenres() {
        return genreRepository.getAllGenres();
    }

}
