package com.excellent_reads.excellent_reads.controllers;

import com.excellent_reads.models.Book;
import com.excellent_reads.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:5173")
public class BookController {

    private final BookService bookService;
    private final Logger logger = Logger.getLogger(BookController.class.getName());

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping()
    public List<Book> getAllBooks() {
        logger.info("Get All Books");
        return bookService.getALlBooks();
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getBookById(@PathVariable Long id) {
        if (bookService.getById(id).isEmpty()) {
            logger.info("Not found book with id: " + id);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Not found book with id: " + id);
        } else {
            logger.info("Book with id: " + id);
            return ResponseEntity.of(bookService.getById(id));
        }
    }
}
