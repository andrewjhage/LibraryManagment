package com.example.librarymanagement.domain.user.entities;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@NoArgsConstructor
public class Journal extends LibraryItem {
    @Getter
    @Setter
    private int issueNumber;
    @Getter
    @Setter
    private BigDecimal lateFeePerDay;


    public String getItemDetails() {
        return "Journal: " + getTitle() + " by " + getAuthor() + " (" + getYear() + "), Issue: " + issueNumber + "Quantity: " + getQuantity() + ", Status: " + getStatus();
    }

}
