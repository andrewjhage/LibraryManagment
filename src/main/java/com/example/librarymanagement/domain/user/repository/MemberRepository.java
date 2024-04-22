package com.example.librarymanagement.domain.user.repository;

import com.example.librarymanagement.domain.user.entities.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
