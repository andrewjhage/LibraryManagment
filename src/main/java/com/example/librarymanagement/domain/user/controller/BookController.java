package com.example.librarymanagement.domain.user.controller;

import com.example.librarymanagement.domain.user.CreateBookRequest;
import com.example.librarymanagement.domain.user.UpdateBookRequest;
import com.example.librarymanagement.domain.user.entities.Book;
import com.example.librarymanagement.domain.user.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(value = "/api/service/books")
    public String createBook(@RequestBody CreateBookRequest request) {
        return bookService.createBook(request);
    }

    @PutMapping(value = "/api/service/books/{id}")
    public String updateBook(@RequestBody UpdateBookRequest request, @PathVariable("id") Integer id) {
        return bookService.updateBook(id, request);
    }

    @GetMapping(value = "/api/service/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping(value = "/api/service/books/{id}")
    public Book getBookById(@PathVariable("id") Integer id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping(value = "/api/service/books/{id}")
    public Integer deleteBookById(@PathVariable("id") Integer id) {
        return bookService.deleteBook(id);
    }
}
