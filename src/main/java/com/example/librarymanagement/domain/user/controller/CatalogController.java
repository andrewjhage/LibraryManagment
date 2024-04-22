package com.example.librarymanagement.domain.user.controller;


import com.example.librarymanagement.domain.user.entities.Book;
import com.example.librarymanagement.domain.user.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/service/catalog")
public static class CatalogController {
    @Autowired
    public BookRepository bookRepository;
}

@PostMapping("api/service/books")
public Book addBook(@RequestBody Book book) {
    return bookRepository.save(book);
}

@GetMapping("api/services/books")
public List<Book> getAllBooks() {
    return bookRepository.findAll();
}

@GetMapping("api/service/books/{id}")
public Book getBookById(@PathVariable Long id) {
    return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
}

@PutMapping("api/service/books/{id}")
public Book updateBook(@PathVariable Long id, @RequestBody Book bookDetails) {
    Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    book.setTitle(bookDetails.getTitle());
    book.setAuthor(bookDetails.getAuthor());
    book.setIsbn(bookDetails.getIsbn());
    return bookRepository.save(book);
}

@DeleteMapping("api/service/books/{id}")
public ResponseEntity<?> deleteBook(@PathVariable Long id) {
    bookRepository.deleteById(id);
    return ResponseEntity.ok().build();
}