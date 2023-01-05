package com.codegym.service.customer;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Page<Customer> findAll(String name, String address, String email, Pageable pageable);

    void save(Customer customer);

    void update(Customer customer);

    void delete(int id);

    Optional<Customer> findById(int id);

    List<Customer> cusList();

    List<Customer> findAll2();
}
