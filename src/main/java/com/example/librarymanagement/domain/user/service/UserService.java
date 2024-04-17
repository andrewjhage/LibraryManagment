package com.example.librarymanagement.domain.user.service;

import org.springframework.stereotype.Service;

import javax.security.auth.Subject;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {

    public Integer getId(String id) {
        try {
            return Integer.valueOf(id);
        } catch (NumberFormatException e){
            return 0;
        }
    }

    //I created this on my own
    public Integer getGenre(String genre) {
        return Integer.valueOf(genre);
    }
}
enum ItemStatus {
    AVAILABLE,
    CHECKED_OUT,
    RESERVED,
    NEEDS_REPLACEMENT
}

abstract class LibraryItem {
    protected String title;
    protected String author;
    protected int year;
    protected int quantity;
    protected ItemStatus status;
    protected List<Member> reservationList;


    public LibraryItem(String title, String author, int year, int quantity) {
        this.title = title;
        this.author = author;
        this.year = year;
        this.quantity = quantity;
        this.status = ItemStatus.AVAILABLE;
        this.reservationList = new ArrayList<>();
    }

    public abstract String getItemDetails();

    public void updateStatus(ItemStatus newStatus) {
        this.status = newStatus;
    }

    public void checkout() {
        if (quantity > 0 && status ==ItemStatus.AVAILABLE) {
            quantity--;
            updateStatus(ItemStatus.CHECKED_OUT);
        } else {
            System.out.println("Item not available to checkout.");
        }
    }

    public void returnItem() {
        if (status == ItemStatus.CHECKED_OUT) {
            quantity++;
            updateStatus(ItemStatus.AVAILABLE);
        } else  {
            System.out.println("Item cannot be returned.");
        }
    }

    public void addReservation(Member member) {
        reservationList.add(member);
    }

    public void removeReservation(Member member) {
        reservationList.remove(member);
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public int getQuantity() {
        return quantity;
    }

    public ItemStatus getStatus() {
        return status;
    }

    public abstract double calculateLateFees(int days);
}

class Book extends LibraryItem {
    private String isbn;
    private double lateFeePerDay;

    public Book(String title, String author, int year, String isbn, int quantity, double lateFeePerDay) {
        super(title, author, year, quantity);
        this.isbn = isbn;
        this.lateFeePerDay = lateFeePerDay;
    }

    @Override
    public String getItemDetails() {
        return "Book: " + title + " by " + author + " )"  + year + "), ISBN: " + isbn + "Quantity: " + quantity + ", Status: " + status;
    }

    public String getIsbn(){
        return isbn;
    }

    public double calculateLateFees(int days) {
        return days * lateFeePerDay;
    }
}

class Journal extends LibraryItem {
    private int issueNumber;
    private double lateFeePerDay;

    public Journal(String title, String author, int year, int issueNumber, int quantity, double lateFeePerDay) {
        super(title, author, year, quantity);
        this.issueNumber = issueNumber;
        this.lateFeePerDay = lateFeePerDay;
    }

    @Override
    public String getItemDetails() {
        return "Journal: " + title + " by " + author + " (" + year + "), Issue: " + issueNumber + "Quantity: " + quantity + ", Status: " + status;
    }

    public int getIssueNumber() {
        return issueNumber;
    }

    @Override
    public double calculateLateFees(int days) {
        return days * lateFeePerDay;
    }
}

class Multimedia extends LibraryItem {
    private String format;
    private double lateFeePerDay;

    public Multimedia(String title, String author, int year, String format, int quantity, double lateFeePerDay) {
        super(title, author, year, quantity);
        this.format = format;
        this.lateFeePerDay = lateFeePerDay;
    }

    @Override
    public String getItemDetails() {
        return "Multimedia: " + title + " by " + author + " (" + year + "), Format: " + format + "Quantity: " + quantity + ", Status: " + status;
    }

    public String getFormat() {
        return format;
    }

    @Override
    public double calculateLateFees(int days) {
        return days * lateFeePerDay;
    }
}

class Member {
    private String memberId;
    private String name;
    private String email;
    private List<LibraryItem> borrowedItems;
    private double lateFees;

    public Member(String memberId, String name, String email) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.borrowedItems = new ArrayList<>();
        this.lateFees = 0;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<LibraryItem> getBorrowedItems() {
        return borrowedItems;
    }

    public double getLateFees() {
        return lateFees;
    }

    public void updateLateFees(double fees) {
        this.lateFees += fees;
    }
}

public void displayMemberDetails() {
    System.out.println("Member ID: " + memberId);
    System.out.println("Name: " + name);
    System.out.println("Email: " + email);
    System.out.println("Late Fees: $" + lateFeePerDay);
    System.out.println("Borrowed Items: ");
    if (borrowedItems.isEmpty()) {
        System.out.println("No items borrowed.");
    } else  {
        for (LibraryItem item : borrowedItems) {
            System.out.println("- " + item.getItemDetails());
        }
    }
}

class MemberManagement {
    private List<Member> members;

    public MemberManagement() {
        this.members = new ArrayList<>();
    }

    public void registerMember(String memberId, String name, String email) {
        members.add(newMember);
        System.out.println("Member has been registered.");
    }

    public void updateMemberEmail(String memberId, String newEmail) {
        Member member = findMemberById(memberId);
        if (member != null) {
            member.setEmail(newEmail);
            System.out.println("Member's email has been updated.");
        } else {
            System.out.println("Member not found.");
        }
    }

    private Member findMemberById(String memberId) {
        for (Member member : members) {
            if (member.getMemberId().equals(memberId)) {
                return member;
            }
        }
        return null;
    }

    public void displayMemberDetails(String memberId) {
        Member member = findMemberById(memberId);
        if (member != null) {
            member.displayMemberDetails();
        }else {
            System.out.println("Member not found.");
        }
    }
}

class Catalog {
    private Map<LibraryItem, Integer> inventory;
    private List<Double> lateFeesCollected;

    public Catalog() {
        inventory = new HashMap<>();
        lateFeesCollected = new ArrayList<>();
    }

    public void addItem(LibraryItem item, int quantity) {
        if (inventory.containsKey(item)) {
            inventory.put(item, inventory.get(item) + quantity);
        } else {
            inventory.put(item,quantity);
        }
    }

    public void updateItemStatus(LibraryItem item, ItemStatus newStatus) {
        if (inventory.containsKey(item)) {
            item.updateStatus(newStatus);
        }else {
            System.out.println("Item not found in inventory");
        }
    }

    public void checkoutItem(LibraryItem item) {
        if (inventory.containsKey(item)) {
            item.checkout();
        } else {
            System.out.println("Item not found in inventory");
        }
    }

    public void returnItem(LibraryItem item) {
        if (inventory.containsKey(item)) {
            item.returnItem();
        } else {
            System.out.println("Item not found in inventory");
        }
    }

    public void displayInventory() {
        if (inventory.isEmpty()) {
            System.out.println("No items in inventory");
        } else {
            System.out.println("Library Inventory:");
            for (LibraryItem item : inventory.keySet()) {
                System.out.println(item.getItemDetails());
            }
        }
    }

    public void addReservation(LibraryItem item,Member member) {
        if (inventory.containsKey(item) && item.status == ItemStatus.CHECKED_OUT) {
            item.addReservation(member);
            System.out.println(member.name +" has reserved the item: " + item.title);
        } else {
            System.out.println("This item can not be reserved.");
        }
    }

    public void removeReservation(LibraryItem item,Member member) {
        if (inventory.containsKey(item) && item.reservationList.contains(member)) {
            item.removeReservation(member);
            System.out.println(member.name + "'s reservation for the item:" + item.title + " has been cancelled.");
        } else {
            System.out.println("There is no reservation for this item.");
        }
    }
    public List<LibraryItem> searchByTitle(String title) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : inventory.keySet()) {
            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    public  List<LibraryItem> searchByAuthor(String author) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : inventory.keySet()) {
            if (item instanceof Book && ((Book) item).getAuthor().toLowerCase().contains(author.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> searchByISBN(String isbn) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : inventory.keySet()) {
            if (item instanceof Book && ((Book) item).getIsbn().toLowerCase().contains(isbn.toLowerCase())) {
                result.add(item);
            }
        }
        return result;
    }

    public List<LibraryItem> filterBySubject(String subject) {
        List<LibraryItem> result = new ArrayList<>();
        for (LibraryItem item : inventory.keySet()) {
            Subject itemSubject = getItemSubjecyArea(item);
            if (itemSubject != null && itemSubject.equalsIgnoreCase(subject)) {
                result.add(item);
            }
        }
        return result;
    }
}

class ReportGenerator {
    public static void generateInventoryReport(Catalog catalog){
        System.out.println("Inventory Report:");
        catalog.displayInventory();
    }

    public static void generateBorrowingStatisticsReport(Catalog catalog){
        System.out.println("Borrowing Statistics Report:");
        int totalItems = 0;
        int checkedOutItems = 0;
        int reservedItems = 0;

        for (LibraryItem item : catalog.getInventory().ketSet()) {
            totalItems += item.getQuantity();
            if (item.getStatus() == ItemStatus.CHECKED_OUT) {
                checkedOutItems += item.getQuantity();
            } else if (item.getStatus() == ItemStatus.RESERVED) {
                reservedItems += item.getQuantity();
            }
        }

        System.out.println("Total items: " + totalItems);
        System.out.println("Checked out items: " + checkedOutItems);
        System.out.println("Reserved items: " + reservedItems);
    }

    public static void generateLateFeeReport(List<Member>members){
        System.out.println("Late Fees Collected Report:");
        double totalLateFees = 0;

        for (Member member : members) {
            totalLateFees += member.getLateFees();
        }
        System.out.println("Total Late Fees Collected: $" + totalLateFees);
    }
}