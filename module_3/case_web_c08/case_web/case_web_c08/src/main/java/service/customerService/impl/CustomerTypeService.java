package service.customerService.impl;

import model.customer.CustomerType;
import repository.customer.ICustomerTypeRepository;
import repository.customer.impl.CustomerTypeRepository;
import service.customerService.ICustomerTypeService;

import java.util.List;

public class CustomerTypeService implements ICustomerTypeService {
    private ICustomerTypeRepository customerTypeRepository= new CustomerTypeRepository();
    @Override
    public List<CustomerType> listCustomerType() {
        return customerTypeRepository.listCustomerType();
    }
}
