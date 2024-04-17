package com.example.librarymanagement.domain.user.controller;

import com.example.librarymanagement.domain.user.CreateBookRequest;
import com.example.librarymanagement.domain.user.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping(value="/api/service/books")
    public String blahBlah(@RequestBody CreateBookRequest request) {
       return bookService.createBook(request);
    }
}
