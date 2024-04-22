package com.example.librarymanagement.domain.user.controller;

import com.example.librarymanagement.domain.user.entities.Book;
import com.example.librarymanagement.domain.user.entities.Member;
import com.example.librarymanagement.domain.user.repository.BookRepository;
import com.example.librarymanagement.domain.user.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/services/fees")
public class FeesController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("api/services/calculate")
    public double calculateLateFees(){
        Date today = new Date();
        List<Book> overdueBooks = bookRepository.findByDueDate(today);
        overdueBooks.forEach(book -> {
            Member member = book.getBorrowedBy();
            double fees = calculateLateFees();
            member.setLateFees(member.getLateFees() + fees);
            memberRepository.save(member);
        });
        return 0;
    }

    private double calculateFees(Date dueDate, Date today) {
        long daysOverdue = (today.getTime() - dueDate.getTime()) / (24 * 60 * 60 * 1000);
        return daysOverdue + 0.50;
    }

    @GetMapping("api/services/outstanding")
    public List<Member> getMembersOutstandingFees(){
        return memberRepository.findAll().stream()
                .filter(member -> member.getLateFees() > 0)
                .collect(Collectors.toList());
    }
}
