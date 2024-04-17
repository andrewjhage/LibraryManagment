package com.example.librarymanagement.domain.user.service;

import com.example.librarymanagement.domain.user.CreateBookRequest;
import com.example.librarymanagement.domain.user.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.domain.user.entities.Book;


@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public String createBook(CreateBookRequest request) {

        var book = new Book();
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        book.setYear(request.getYear());
        book.setIsbn(request.getIsbn());
        book.setQuantity(request.getQuantity());
        book.setStatus(request.getStatus());
        book.setLateFeePerDay(request.getLateFeePerDay());
        book.setGenre(request.getGenre());

        bookRepository.save(book);

        return "OK";
    }
}
