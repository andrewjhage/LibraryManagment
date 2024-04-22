package com.example.librarymanagement.domain.user.controller;


import com.example.librarymanagement.domain.user.entities.Book;
import com.example.librarymanagement.domain.user.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    private BookRepository bookRepository;

    @PutMapping("api/service/books/{id}/quantity")
    public Book updateBookQuantity(@PathVariable Long id, @RequestParam int quantity) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setQuantity(quantity);
        book.setAvailable(quantity);
        return bookRepository.save(book);
    }

    @PutMapping("api/service/books/{id}/available")
    public Book updateBookAvailable(@PathVariable Long id, @RequestParam int adjustBy) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        int newAvailability = book.getAvailable() + adjustBy;
        if (newAvailability < 0 || newAvailability > book.getQuantity()) {
            throw new RuntimeException("Invalid availability");
        }
        book.setAvailable(newAvailability);
        return bookRepository.save(book);
    }

    @GetMapping("api/service/books")
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }
}
