package com.codegym.service.emoloyee;

import com.codegym.model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
}
