package com.example.librarymanagement.domain.user.entities;
import com.example.librarymanagement.domain.user.enums.ItemStatus;
import javax.security.auth.Subject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
//    private Map<LibraryItem, Integer> inventory;
//    private List<Double> lateFeesCollected;
//
//    public Catalog() {
//        inventory = new HashMap<>();
//        lateFeesCollected = new ArrayList<>();
//    }
//
//    public void addItem(LibraryItem item, int quantity) {
//        if (inventory.containsKey(item)) {
//            inventory.put(item, inventory.get(item) + quantity);
//        } else {
//            inventory.put(item,quantity);
//        }
//    }
//
//    public void updateItemStatus(LibraryItem item, ItemStatus newStatus) {
//        if (inventory.containsKey(item)) {
//            item.updateStatus(newStatus);
//        }else {
//            System.out.println("Item not found in inventory");
//        }
//    }
//
//    public void checkoutItem(LibraryItem item) {
//        if (inventory.containsKey(item)) {
//            item.checkout();
//        } else {
//            System.out.println("Item not found in inventory");
//        }
//    }
//
//    public void returnItem(LibraryItem item) {
//        if (inventory.containsKey(item)) {
//            item.returnItem();
//        } else {
//            System.out.println("Item not found in inventory");
//        }
//    }
//
//    public void displayInventory() {
//        if (inventory.isEmpty()) {
//            System.out.println("No items in inventory");
//        } else {
//            System.out.println("Library Inventory:");
//            for (LibraryItem item : inventory.keySet()) {
//                System.out.println(item.getItemDetails());
//            }
//        }
//    }
//
//    public void addReservation(LibraryItem item, Member member) {
//        if (inventory.containsKey(item) && item.status == ItemStatus.CHECKED_OUT) {
//            item.addReservation(member);
//            System.out.println(member.getName() +" has reserved the item: " + item.title);
//        } else {
//            System.out.println("This item can not be reserved.");
//        }
//    }
//
//    public void removeReservation(LibraryItem item, Member member) {
//        if (inventory.containsKey(item) && item.reservationList.contains(member)) {
//            item.removeReservation(member);
//            System.out.println(member.getName() + "'s reservation for the item:" + item.title + " has been cancelled.");
//        } else {
//            System.out.println("There is no reservation for this item.");
//        }
//    }
//    public List<LibraryItem> searchByTitle(String title) {
//        List<LibraryItem> result = new ArrayList<>();
//        for (LibraryItem item : inventory.keySet()) {
//            if (item.getTitle().toLowerCase().contains(title.toLowerCase())) {
//                result.add(item);
//            }
//        }
//        return result;
//    }
//
//    public  List<LibraryItem> searchByAuthor(String author) {
//        List<LibraryItem> result = new ArrayList<>();
//        for (LibraryItem item : inventory.keySet()) {
//            if (item instanceof Book && ((Book) item).getAuthor().toLowerCase().contains(author.toLowerCase())) {
//                result.add(item);
//            }
//        }
//        return result;
//    }
//
//    public List<LibraryItem> searchByISBN(String isbn) {
//        List<LibraryItem> result = new ArrayList<>();
//        for (LibraryItem item : inventory.keySet()) {
//            if (item instanceof Book && ((Book) item).getIsbn().toLowerCase().contains(isbn.toLowerCase())) {
//                result.add(item);
//            }
//        }
//        return result;
//    }
//
//    public List<LibraryItem> filterBySubject(String subject) {
//        List<LibraryItem> result = new ArrayList<>();
//        for (LibraryItem item : inventory.keySet()) {
//            Subject itemSubject = getItemSubjecyArea(item);
//            if (itemSubject != null && itemSubject.equalsIgnoreCase(subject)) {
//                result.add(item);
//            }
//        }
//        return result;
//    }
}