package com.codegym.service.impl;

import com.codegym.model.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> findAll();

    Optional<User> findAllById(int id);

    void save(User user);

    void deleteById(int id);


    void update(User user);
}
