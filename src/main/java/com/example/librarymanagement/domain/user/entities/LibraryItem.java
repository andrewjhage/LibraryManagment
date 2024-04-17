package com.example.librarymanagement.domain.user.entities;


import com.example.librarymanagement.domain.user.enums.ItemStatus;
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
//    @Getter
//    @Setter
//    private List<Member> reservationList;

//    public String getAuthor() {
//        return  this.author;
//    }

//    public LibraryItem(String title, String author, int year, int quantity) {
//        this.title = title;
//        this.author = author;
//        this.year = year;
//        this.quantity = quantity;
//        this.status = ItemStatus.AVAILABLE;
//        this.reservationList = new ArrayList<>();
//    }
//
//    public abstract String getItemDetails();
//
//    public void updateStatus(ItemStatus newStatus) {
//        this.status = newStatus;
//    }
//
//    public void checkout() {
//        if (quantity > 0 && status ==ItemStatus.AVAILABLE) {
//            quantity--;
//            updateStatus(ItemStatus.CHECKED_OUT);
//        } else {
//            System.out.println("Item not available to checkout.");
//        }
//    }
//
//    public void returnItem() {
//        if (status == ItemStatus.CHECKED_OUT) {
//            quantity++;
//            updateStatus(ItemStatus.AVAILABLE);
//        } else  {
//            System.out.println("Item cannot be returned.");
//        }
//    }
//
//    public void addReservation(Member member) {
//        reservationList.add(member);
//    }
//
//    public void removeReservation(Member member) {
//        reservationList.remove(member);
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public int getQuantity() {
//        return quantity;
//    }
//
//    public ItemStatus getStatus() {
//        return status;
//    }
//
//    public abstract double calculateLateFees(int days);
}