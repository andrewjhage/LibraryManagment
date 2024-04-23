package com.example.librarymanagement.domain.user.repository;
import org.springframework.stereotype.Repository;
import com.example.librarymanagement.domain.user.entities.Book;

import java.util.Date;
import java.util.List;

@Repository
public interface BookRepository extends CoreRepository<Book, Integer> {
//    List<Book> findById(Long id);
//    List<Book> findByTitleContaining(String title);
//    List<Book> findByAuthorContaining(String author);
//    List<Book> findByIsbn(String isbn);
//    List<Book> findBySubjectAreaContaining(String subjectArea);
//    List<Book> findByDueDate(Date today);
//    List<Object[]> countBooksByCategory();
}
