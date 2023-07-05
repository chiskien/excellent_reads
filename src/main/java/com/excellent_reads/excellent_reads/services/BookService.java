package com.excellent_reads.excellent_reads.services;

import com.excellent_reads.models.Book;
import com.excellent_reads.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getALlBooks() {
        return bookRepository.getAll();
    }

    public Optional<Book> getById(Long id) {
        return bookRepository.getById(id);
    }

    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Long id) {
        bookRepository.delete(id);
    }
}
