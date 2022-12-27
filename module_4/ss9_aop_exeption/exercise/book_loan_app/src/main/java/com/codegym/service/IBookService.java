package com.codegym.service;

import com.codegym.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBookService {
    Page<Book> showList(Pageable pageable);

    void save(Book book);

    void update(Book book);

    void deleteById(int id);
}
