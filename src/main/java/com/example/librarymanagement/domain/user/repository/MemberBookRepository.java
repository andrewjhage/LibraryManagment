package com.example.librarymanagement.domain.user.repository;

import com.example.librarymanagement.domain.user.entities.MemberBook;

import java.util.List;

public interface MemberBookRepository extends CoreRepository<MemberBook, Integer> {
    List<MemberBook> findAllByMember_Id(Integer id);
}
