package com.example.librarymanagement.domain.user.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;

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
    //@ManyToOne
    private String borrowedBy;
    @Getter
    @Setter
    //@ManyToOne
    private String dueDate;
    @Getter
    @Setter
    private String subjectArea;

    @Getter
    @Setter
    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberBook> members = new ArrayList<>();

    public String getDetails() {
        return "Book: " + getTitle() + " by " + getAuthor() + " )" + getYear() + "), ISBN: " + isbn + "Quantity: " + getQuantity() + ", Status: " + getStatus();
    }
}