package com.example.librarymanagement.domain.user.repository;

import com.example.librarymanagement.domain.user.entities.Book;
import com.example.librarymanagement.domain.user.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByReservedBook(Book book, boolean isActive);
}
