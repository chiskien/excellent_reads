package com.excellent_reads.repositories;

import com.excellent_reads.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository implements BaseRepository<Book> {

    private final JdbcTemplate jdbcTemplate;
    private final RowMapper<Book> bookRowMapper = (rs, rowNum) ->
            new Book(rs.getLong("id"),
                    rs.getString("title"),
                    rs.getString("cover"),
                    rs.getString("description"),
                    rs.getDate("published_date"),
                    rs.getInt("pages")
            );

    @Autowired
    public BookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query("SELECT * FROM book", bookRowMapper);

    }

    @Override
    public Book getById(Long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?",
                bookRowMapper, id);
    }

    @Override
    public void delete(Long id) {
        System.out.println();
    }

    @Override
    public Book save(Book entity) {
        return null;
    }
}
