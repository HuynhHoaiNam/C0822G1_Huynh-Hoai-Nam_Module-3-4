package service;

import model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> listCustomer();

    void create(Customer customer);

    boolean update(Customer customer);

    boolean delete(int id);

    List<Customer> findCustomer(int id, String name, String address);
}
