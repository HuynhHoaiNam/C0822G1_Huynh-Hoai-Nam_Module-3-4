package com.codegym.service;

import com.codegym.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import java.util.Optional;

public interface IProductService {
   List<Product> showList();

    Optional<Product> findById(int id);
}
