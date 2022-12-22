package com.codegym.service;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void remove(int id);

    Optional<Blog> findAllById(int id);

    void edit(Blog blog);

    Page<Blog> listSort(Pageable pageable);

}
