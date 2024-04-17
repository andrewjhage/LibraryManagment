package com.example.librarymanagement.domain.user.repository;
import org.springframework.stereotype.Repository;
import com.example.librarymanagement.domain.user.entities.Book;

@Repository
public interface BookRepository extends CoreRepository<Book, Integer> {
}
