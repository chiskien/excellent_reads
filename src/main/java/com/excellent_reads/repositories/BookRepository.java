package com.excellent_reads.repositories;

import com.excellent_reads.models.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RowMapper<Book> bookRowMapper = (rs, rowNum) ->
            new Book(rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("cover"),
                    rs.getString("description"),
                    rs.getDate("published_date"),
                    rs.getInt("pages")
            );

    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Book> getAllBooks() {
        return jdbcTemplate.query("SELECT * FROM book", bookRowMapper);
    }

    public Book getBookById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?",
                bookRowMapper, id);
    }
}
