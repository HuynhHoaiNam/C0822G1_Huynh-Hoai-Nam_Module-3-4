package com.codegym.service.customer.impl;

import com.codegym.model.customer.Customer;
import com.codegym.repository.customer.ICustomerRepository;
import com.codegym.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private ICustomerRepository customerRepository;


    @Override
    public Page<Customer> findAll(String name, String email, int customerType, Pageable pageable) {
        return customerRepository.showList(name, email, customerType, pageable);
    }

    @Override
    public Page<Customer> findAllNoId(String name, String email, Pageable pageable) {
        return customerRepository.showListNoId(name, email, pageable);
    }


    @Override
    public boolean save(Customer customer) {
        for (int i = 0; i < cusList().size(); i++) {
            if (customer.getEmail().equals(cusList().get(i).getEmail()) ||
                    customer.getIdCard().equals(cusList().get(i).getIdCard()) ||
                    customer.getPhoneNumber().equals(cusList().get(i).getPhoneNumber())) {
                return false;
            }
        }
        customerRepository.save(customer);
        return true;
    }

    @Override
    public void update(Customer customer) {
        customerRepository.save(customer);
    }

    @Override
    public void delete(int id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Optional<Customer> findById(int id) {
        return customerRepository.findById(id);
    }

    @Override
    public List<Customer> cusList() {
        return customerRepository.findAll();
    }

    @Override
    public List<Customer> findAll2() {
        return customerRepository.findAll();
    }

}
