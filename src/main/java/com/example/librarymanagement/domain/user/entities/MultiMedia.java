package com.example.librarymanagement.domain.user.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class MultiMedia extends LibraryItem {
    @Getter
    @Setter
    private String format;
    @Getter
    @Setter
    private BigDecimal lateFeePerDay;

//    public MultiMedia(String title, String author, int year, String format, int quantity, double lateFeePerDay) {
//        super(title, author, year, quantity);
//        this.format = format;
//        this.lateFeePerDay = lateFeePerDay;
//    }


    public String getItemDetails() {
        return "MultiMedia: " + getTitle() + " by " + getAuthor() + " (" + getYear() + "), Format: " + format + "Quantity: " + getQuantity() + ", Status: " + getStatus();
    }

    public String getFormat() {
        return format;
    }
//
//    public double calculateLateFees(int days) {
//        return days * lateFeePerDay;
//    }
}
