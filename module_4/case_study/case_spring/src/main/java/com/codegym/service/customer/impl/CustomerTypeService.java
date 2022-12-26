package com.codegym.service.customer.impl;

import com.codegym.model.customer.CustomerType;
import com.codegym.repository.customer.ICustomerTypeRepository;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.customer.ICustomerTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerTypeService implements ICustomerTypeService {
    @Autowired
    private ICustomerTypeRepository customerTypeRepository;

    @Override
    public List<CustomerType> showList() {
        return customerTypeRepository.findAll();
    }
}
