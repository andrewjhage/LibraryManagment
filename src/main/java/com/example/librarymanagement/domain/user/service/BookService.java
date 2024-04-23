package com.example.librarymanagement.domain.user.service;

import com.example.librarymanagement.domain.user.CreateBookRequest;
import com.example.librarymanagement.domain.user.UpdateBookRequest;
import com.example.librarymanagement.domain.user.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.domain.user.entities.Book;

import java.util.List;


@Service
public class BookService {
    @Autowired
    public BookRepository bookRepository;

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

        return book.getDetails();
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public String updateBook(Integer id, UpdateBookRequest request) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
        book.setTitle(request.getTitle());
        book.setAuthor(request.getAuthor());
        bookRepository.save(book);
        return book.getDetails();
    }

    public Integer deleteBook(Integer id) {
        bookRepository.deleteById(id);
        return id;
    }
}
