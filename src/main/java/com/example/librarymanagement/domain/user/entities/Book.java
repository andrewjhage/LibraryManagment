package com.example.librarymanagement.domain.user.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
public class Book extends LibraryItem {

    @Getter
    @Setter
    private String isbn;
    @Getter
    @Setter
    private BigDecimal lateFeePerDay;
    @Getter
    @Setter
    private String genre;

    @Getter
    @Setter
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberBook> members = new ArrayList<>();

//
//    public Book(String title, String author, int year, String isbn, int quantity, double lateFeePerDay) {
//        super(title, author, year, quantity);
//        this.isbn = isbn;
//        this.lateFeePerDay = lateFeePerDay;
//    }

    public String getItemDetails() {
        return "Book: " + getTitle() + " by " + getAuthor() + " )"  + getYear() + "), ISBN: " + isbn + "Quantity: " + getQuantity() + ", Status: " + getStatus();
    }

//    public String getIsbn(){
//        return isbn;
//    }
//
//    public BigDecimal calculateLateFees(int days) {
//        return days * getLateFeePerDay();
//    }
}