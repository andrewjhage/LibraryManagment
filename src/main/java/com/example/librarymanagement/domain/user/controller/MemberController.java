package com.example.librarymanagement.domain.user.controller;

import com.example.librarymanagement.domain.user.CreateBookRequest;
import com.example.librarymanagement.domain.user.CreateMemberRequest;
import com.example.librarymanagement.domain.user.UpdateBookRequest;
import com.example.librarymanagement.domain.user.UpdateMemberRequest;
import com.example.librarymanagement.domain.user.entities.Book;
import com.example.librarymanagement.domain.user.entities.Member;
import com.example.librarymanagement.domain.user.service.BookService;
import com.example.librarymanagement.domain.user.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class MemberController {
    @Autowired
    private MemberService memberService;

    @PostMapping(value = "/api/service/members")
    public String createMember(@RequestBody CreateMemberRequest request) {
        return memberService.createMember(request);
    }

    @PutMapping(value = "/api/service/members/{id}")
    public String updateMember(@RequestBody UpdateMemberRequest request, @PathVariable("id") Integer id) {
        return memberService.updateMember(id, request);
    }

    @GetMapping(value = "/api/service/members/{id}")
    public Member getMemberById(@PathVariable("id") Integer id) {
        return memberService.getMemberById(id);
    }

    @DeleteMapping(value = "/api/service/members/{id}")
    public Integer deleteMemberById(@PathVariable("id") Integer id) {
        return memberService.deleteMember(id);
    }

    @GetMapping(value = "/api/service/members/{id}/late_fees")
    public String getMemberLateFees(@PathVariable("id") Integer id) {
        return memberService.getLateFees(id);
    }

    @GetMapping(value = "/api/service/members/{id}/books")
    public List<Book> getMemberBooks(@PathVariable("id") Integer id) {
        return memberService.getMemberBooks(id);
    }

    @PostMapping(value = "/api/service/members/{id}/books/{book_id}")
    public Boolean checkoutBook(@PathVariable("id") Integer id, @PathVariable("book_id") Integer bookId) {
        return memberService.checkoutBook(id, bookId);
    }
}
