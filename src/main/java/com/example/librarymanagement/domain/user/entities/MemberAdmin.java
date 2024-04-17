package com.example.librarymanagement.domain.user.entities;

import java.util.ArrayList;
import java.util.List;

public class MemberAdmin {
    private List<Member> members;

    public MemberAdmin() {
        this.members = new ArrayList<>();
    }

//    public void registerMember(String memberId, String name, String email) {
//        members.add(newMember);
//        System.out.println("Member has been registered.");
//    }
//
//    public void updateMemberEmail(String memberId, String newEmail) {
//        Member member = findMemberById(memberId);
//        if (member != null) {
//            member.setEmail(newEmail);
//            System.out.println("Member's email has been updated.");
//        } else {
//            System.out.println("Member not found.");
//        }
//    }
//
//    private java.lang.reflect.Member findMemberById(String memberId) {
//        for (Member member : members) {
//            if (member.getMemberId().equals(memberId)) {
//                return member;
//            }
//        }
//        return null;
//    }
//
//    public void displayMemberDetails(String memberId) {
//        Member member = findMemberById(memberId);
//        if (member != null) {
//            member.displayMemberDetails();
//        }else {
//            System.out.println("Member not found.");
//        }
//    }
}