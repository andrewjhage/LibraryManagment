package com.example.librarymanagement.domain.user.entities;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
public class Member {
    @Id
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String memberId;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private String email;
    @Getter
    @Setter
    private List<Book> borrowedBooks;
    @Getter
    @Setter
    private Date registrationDate;

    @Getter
    @Setter
    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<MemberBook> books = new ArrayList<>();

    @Getter
    @Setter
    private double lateFees;
//
//    public Member(String memberId, String name, String email) {
//        this.memberId = memberId;
//        this.name = name;
//        this.email = email;
//        this.borrowedItems = new ArrayList<>();
//        this.lateFees = 0;
//    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

//    public List<LibraryItem> getBorrowedItems() {
//        return borrowedItems;
//    }

    public double getLateFees() {
        return lateFees;
    }

    public void updateLateFees(double fees) {
        this.lateFees += fees;
    }

//    public void displayMemberDetails() {
//        System.out.println("Member ID: " + memberId);
//        System.out.println("Name: " + name);
//        System.out.println("Email: " + email);
//        System.out.println("Late Fees: $" + getLateFees());
//        System.out.println("Borrowed Items: ");
//        if (borrowedItems.isEmpty()) {
//            System.out.println("No items borrowed.");
//        } else  {
//            for (LibraryItem item : borrowedItems) {
//                System.out.println("- " + item.getItemDetails());
//            }
//        }
//    }
}
