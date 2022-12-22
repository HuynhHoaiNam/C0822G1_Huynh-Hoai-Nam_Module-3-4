package com.codegym.service;


import com.codegym.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    void save(Category category);

    void remove(int id);

    Optional<Category> findAllById(int id);

    void edit(Category category);
}
