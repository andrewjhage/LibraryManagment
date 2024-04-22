package com.example.librarymanagement.domain.user;

import lombok.*;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateBookRequest {

    private String title;

    private String author;

    private int year;

    private int quantity;

    private String status;

    private String isbn;

    private BigDecimal lateFeePerDay;

    private String genre;

}
