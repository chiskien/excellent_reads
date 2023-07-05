package com.excellent_reads.excellent_reads.repositories;

import com.excellent_reads.models.Book;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Repository
public class BookRepository implements BaseRepository<Book> {
    private final Logger logger = Logger.getLogger(BookRepository.class.getName());
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

    @Override
    public List<Book> getAll() {
        return jdbcTemplate.query("SELECT * FROM book", bookRowMapper);

    }

    @Override
    public Optional<Book> getById(Long id) {
        Book b;
        try {
            b = jdbcTemplate.queryForObject("SELECT * FROM book WHERE id = ?",
                    bookRowMapper, id);
        } catch (DataAccessException dataAccessException) {
            return Optional.empty();
        }
        return (b != null) ? Optional.of(b) : Optional.empty();
    }

    @Override
    public void delete(Long id) {
        try {
            var optionalBook = getById(id);
            if (optionalBook.isPresent()) {
                Book b = optionalBook.get();
                jdbcTemplate.update("delete from book where id = ?", b.getId());
            }
        } catch (DataAccessException dataAccessException) {
            throw new RuntimeException(dataAccessException.getMessage());
        }
    }

    @Override
    public Book save(Book book) {
        try {
            jdbcTemplate.update("""
                    insert into book (title, cover, description, isbn, published_date, publisher_id, pages, type_id, total_ratings, average_ratings, total_reviews, status, language, original_title, country)
                    values (?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?, ?,?)
                    """
            );
        } catch (DataAccessException dataAccessException) {
            logger.info(dataAccessException.getMessage());
        }
        return book;
    }

}
