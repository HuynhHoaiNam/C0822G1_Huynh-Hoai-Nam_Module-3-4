package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> listCustomer();

    void create(Customer customer);

    boolean update(Customer customer);

    boolean delete(int id);

    List<Customer> findCustomer(int id, String name, String address);

}
