package com.example.librarymanagement.domain.user.controller;

import com.example.librarymanagement.domain.user.entities.Book;
import com.example.librarymanagement.domain.user.entities.Member;
import com.example.librarymanagement.domain.user.entities.Reservation;
import com.example.librarymanagement.domain.user.repository.BookRepository;
import com.example.librarymanagement.domain.user.repository.MemberRepository;
import com.example.librarymanagement.domain.user.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/services/reservations")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;
    @Autowired
    private BookRepository bookRepository;
    @Autowired
    private MemberRepository memberRepository;

    @PostMapping("api/services/make")
    public Reservation makeReservation(@RequestBody Long bookId, @RequestBody Long memberId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("Member not found"));

        if (book.getAvailable() > 0) {
            throw new RuntimeException("Book is available, no reservation needed.");
        }

        Reservation reservation = new Reservation();
        reservation.setReservedBook(book);
        reservation.setMember(member);
        reservation.setReservationDate(new Date());
        reservation.setActive(true);

        return reservationRepository.save(reservation);
    }

    @PostMapping("api/services/cancel")
    public ResponseEntity<?> cancelReservation(@RequestBody Long reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new RuntimeException("Reservation not found"));
        reservation.setIsActive(false);
        reservationRepository.save(reservation);
        return ResponseEntity.ok().body("Reservation cancelled.");
    }

    @GetMapping("api/services/list")
    public List<Reservation> listReservationsForBook(@RequestParam Long bookId) {
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book not found"));
        return reservationRepository.findByReservedBook(book,true);
    }
}
