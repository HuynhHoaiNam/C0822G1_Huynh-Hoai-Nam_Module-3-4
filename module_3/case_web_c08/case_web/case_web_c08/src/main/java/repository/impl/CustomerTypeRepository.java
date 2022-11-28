package repository.impl;

import model.CustomerType;
import repository.BaseRepository;
import repository.ICustomerRepository;
import repository.ICustomerTypeRepository;
import service.ICustomerTypeService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository implements ICustomerTypeRepository {
private final String SELECT_ALL_CT="select * from customer_type;";

    @Override
    public List<CustomerType> listCustomerType() {
        List<CustomerType> customerTypeList= new ArrayList<>();
        Connection connection= BaseRepository.getConnectDB();
        try {
            PreparedStatement ps=connection.prepareStatement(SELECT_ALL_CT);
            ResultSet resultSet=ps.executeQuery();
            while (resultSet.next()){
                int id= resultSet.getInt("id");
                String nameCTType=resultSet.getString("name");
                CustomerType customerType= new CustomerType(id,nameCTType);
                customerTypeList.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
