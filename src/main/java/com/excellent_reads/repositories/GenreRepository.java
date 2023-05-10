package com.excellent_reads.repositories;

import com.excellent_reads.models.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenreRepository {
    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Genre> genreRowMapper = (rs, rowNum) ->
            new Genre(rs.getInt("genre_id"), rs.getString("genre_name"));


    public GenreRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Genre> getAllGenres() {
        return jdbcTemplate.query("SELECT * from genre", genreRowMapper);

    }

}
