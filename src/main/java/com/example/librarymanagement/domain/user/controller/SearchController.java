package com.example.librarymanagement.domain.user.controller;

import com.example.librarymanagement.domain.user.entities.Book;
import com.example.librarymanagement.domain.user.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/services/search")
public class SearchController {
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("api/services/title")
    public List<Book> searchByTitle(@RequestParam String title) {
        return bookRepository.findByTitleContaining(title);
    }

    @GetMapping("api/services/author")
    public List<Book> searchByAuthor(@RequestParam String author) {
        return bookRepository.findByAuthorContaining(author);
    }
    @GetMapping("api/services/isbn")
    public List<Book> searchByIsbn(@RequestParam String isbn) {
        return bookRepository.findByIsbn(isbn);
    }

    @GetMapping("api/services/subject")
    public List<Book> searchBySubject(@RequestParam String subjectArea) {
        return bookRepository.findBySubjectAreaContaining(subjectArea);
    }
}
