package com.example.librarymanagement.domain.user.controller;

import com.example.librarymanagement.domain.user.entities.Member;
import com.example.librarymanagement.domain.user.repository.BookRepository;
import com.example.librarymanagement.domain.user.repository.BorrowingRepository;
import com.example.librarymanagement.domain.user.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/services/reports")
public class ReportingController {
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private BorrowingRepository borrowingRepository;
    @Autowired
    private MemberRepository memberRepository;

    @GetMapping("api/services/inventory")
    public List<Object[]> getInventoryReport() {
        return bookRepository.countBooksByCategory();
    }

    @GetMapping("api/services/borrowing-stats")
    public List<Object[]> getBorrowingStatsReport() {
        return borrowingRepository.countActiveBorrowingByCategory();
    }

    @GetMapping("api/services/late-fees")
        public Double getTotalLateFees() {
            return memberRepository.findAll().stream()
                    .mapToDouble(Member::getLateFees)
                    .sum();
    }
}
