package com.example.test.service;

import com.example.test.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    void save(Blog blog);

    void remove(int id);

    Optional<Blog> findAllById(int id);

    void edit(Blog blog);
}
