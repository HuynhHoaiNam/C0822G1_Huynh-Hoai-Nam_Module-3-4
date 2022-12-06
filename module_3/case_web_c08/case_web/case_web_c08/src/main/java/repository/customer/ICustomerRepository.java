package repository;

import model.Customer;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> listCustomer();

    boolean create(Customer customer);

    boolean update(Customer customer);

    boolean delete(int id);

    List<Customer> findCustomer(String name, String address);

    Customer findById(int id);
}
