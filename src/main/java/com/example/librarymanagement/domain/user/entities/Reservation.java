package com.example.librarymanagement.domain.user.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Entity
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;
    @Getter
    @Setter
    private Date reservationDate;
    @Getter
    @Setter
    @ManyToOne
    private Member member;
    @Getter
    @Setter
    @ManyToOne
    private Book reservedBook;

    public void setIsActive(boolean b) {
    }
}
