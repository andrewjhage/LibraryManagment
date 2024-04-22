package com.example.librarymanagement.domain.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BorrowingRepository<Borrowing> extends JpaRepository<Borrowing, Long> {
    List<Object[]> countActiveBorrowingByCategory();
}
