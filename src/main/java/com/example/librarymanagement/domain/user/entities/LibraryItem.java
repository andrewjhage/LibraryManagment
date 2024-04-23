package com.example.librarymanagement.domain.user.entities;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;


@MappedSuperclass
public class LibraryItem {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Getter
    @Setter
    private Integer id;
    @Getter
    @Setter
    private String title;
    @Getter
    @Setter
    private String author;
    @Getter
    @Setter
    private int year;
    @Getter
    @Setter
    private int quantity;
    @Getter
    @Setter
    private String status;
}