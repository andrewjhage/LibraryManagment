package com.example.librarymanagement.domain.user.controller;

import com.example.librarymanagement.domain.user.entities.Book;
import com.example.librarymanagement.domain.user.entities.Member;
import com.example.librarymanagement.domain.user.repository.BookRepository;
import com.example.librarymanagement.domain.user.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("api/services/borrowing")
public class BorrowingController {
        @Autowired
        private BookRepository bookRepository;
        @Autowired
        private MemberRepository memberRepository;

        @PostMapping("api/services/checkout")
        public ResponseEntity<?> checkoutBook(@RequestParam Long bookId, @RequestParam Long memberId, @RequestParam int days) {
            Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Member not found"));
            Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));

            if (book.getAvailable() <= 0) {
                return ResponseEntity.badRequest().body("No copies available");
            }
            book.setTitle(book.getAvailable() - 1);
            book.setBorrowedBy(String.valueOf(member));
            book.setDueDate(String.valueOf(new Date(System.currentTimeMillis() + (days * 86400000L))));

            bookRepository.save(book);
            return ResponseEntity.ok().body("Book checked out successfully");
        }
        @PostMapping("api/services/return")
        public ResponseEntity<?> returnBook(@RequestParam Long bookId) {
            Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));

            book.setTitle(book.getTitle() + 1);
            book.setBorrowedBy(null);
            book.setDueDate(null);

            bookRepository.save(book);
            return ResponseEntity.ok().body("Book returned successfully");
        }
}

