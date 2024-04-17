package com.example.librarymanagement.domain.user.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class MemberBook {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    @ManyToOne
    private Member member;

    @Getter
    @Setter
    @ManyToOne
    private Book book;


}
