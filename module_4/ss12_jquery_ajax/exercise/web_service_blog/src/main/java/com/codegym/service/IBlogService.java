package com.codegym.service;

import com.codegym.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void remove(int id);

    Optional<Blog> findById(int id);

    void edit(Blog blog);

    List<Blog> listSort( String title);

}
