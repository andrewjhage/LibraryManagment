package com.example.librarymanagement.domain.user.service;

import com.example.librarymanagement.domain.user.CreateBookRequest;
import com.example.librarymanagement.domain.user.CreateMemberRequest;
import com.example.librarymanagement.domain.user.UpdateBookRequest;
import com.example.librarymanagement.domain.user.UpdateMemberRequest;
import com.example.librarymanagement.domain.user.entities.Member;
import com.example.librarymanagement.domain.user.entities.MemberBook;
import com.example.librarymanagement.domain.user.repository.BookRepository;
import com.example.librarymanagement.domain.user.repository.MemberBookRepository;
import com.example.librarymanagement.domain.user.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.librarymanagement.domain.user.entities.Book;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;


@Service
public class MemberService {
    @Autowired
    public MemberRepository memberRepository;
    @Autowired
    public MemberBookRepository memberBookRepository;
    @Autowired
    private BookRepository bookRepository;

    public String createMember(CreateMemberRequest request) {

        var member = new Member();
        member.setName(request.getName());
        member.setEmail(request.getEmail());
        member.setMemberId(request.getMemberId());
        member.setRegistrationDate(Instant.now());

        memberRepository.save(member);

        return member.getDetails();
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Integer id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
    }

    public String updateMember(Integer id, UpdateMemberRequest request) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));

        member.setEmail(request.getEmail());
        memberRepository.save(member);
        return member.getDetails();
    }

    public Integer deleteMember(Integer id) {
        memberRepository.deleteById(id);
        return id;
    }

    public String getLateFees(Integer id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        return member.getMemberLateFees();
    }

    public List<Book> getMemberBooks(Integer id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        List<MemberBook> memberBooks = memberBookRepository.findAllByMember_Id(member.getId());
        var books = new ArrayList<Book>();
        for (var memberBook : memberBooks) {
            books.add(memberBook.getBook());
        }
        return books;
    }

    public Boolean checkoutBook(Integer memberId, Integer bookId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new RuntimeException("Member not found"));
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new RuntimeException("Book not found"));

        MemberBook memberBook = new MemberBook();
        memberBook.setMember(member);
        memberBook.setBook(book);

        member.getBooks().add(memberBook);
        memberRepository.save(member);
        return true;
    }
}
