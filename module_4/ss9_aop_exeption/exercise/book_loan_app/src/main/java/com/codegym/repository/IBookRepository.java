package com.codegym.repository;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IBookRepository extends JpaRepository<Book, Integer> {

    @Query(value = "select * from book where count = 1", nativeQuery = true)
    Page<Book> showListBook(Pageable pageable);
}
