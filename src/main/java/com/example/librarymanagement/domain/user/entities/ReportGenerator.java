package com.example.librarymanagement.domain.user.entities;


import java.lang.reflect.Member;
import java.util.List;

public class ReportGenerator {
//    public static void generateInventoryReport(Catalog catalog){
//        System.out.println("Inventory Report:");
//        catalog.displayInventory();
//    }
//
//    public static void generateBorrowingStatisticsReport(Catalog catalog){
//        System.out.println("Borrowing Statistics Report:");
//        int totalItems = 0;
//        int checkedOutItems = 0;
//        int reservedItems = 0;
//
//        for (LibraryItem item : catalog.getInventory().ketSet()) {
//            totalItems += item.getQuantity();
//            if (item.getStatus() == ItemStatus.CHECKED_OUT) {
//                checkedOutItems += item.getQuantity();
//            } else if (item.getStatus() == ItemStatus.RESERVED) {
//                reservedItems += item.getQuantity();
//            }
//        }
//
//        System.out.println("Total items: " + totalItems);
//        System.out.println("Checked out items: " + checkedOutItems);
//        System.out.println("Reserved items: " + reservedItems);
//    }
//
//    public static void generateLateFeeReport(List<java.lang.reflect.Member> members){
//        System.out.println("Late Fees Collected Report:");
//        double totalLateFees = 0;
//
//        for (Member member : members) {
//            totalLateFees += member.getLateFees();
//        }
//        System.out.println("Total Late Fees Collected: $" + totalLateFees);
//    }
}