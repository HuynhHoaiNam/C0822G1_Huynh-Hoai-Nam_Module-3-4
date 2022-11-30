package service.impl;

import model.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.List;

public class CustomerService implements ICustomerService {
   private ICustomerRepository customerRepository= new CustomerRepository();

    @Override
    public List<Customer> listCustomer() {
        return customerRepository.listCustomer();
    }

    @Override
    public void create(Customer customer) {
        customerRepository.create(customer);
    }

    @Override
    public boolean update(Customer customer) {
        return customerRepository.update(customer);
    }

    @Override
    public boolean delete(int id) {
        return customerRepository.delete(id);
    }

    @Override
    public List<Customer> findCustomer(String name, String address) {
        return customerRepository.findCustomer(name, address);
    }
}
