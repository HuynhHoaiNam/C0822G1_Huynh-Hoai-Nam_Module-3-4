package repository.impl;

import model.Customer;
import model.CustomerType;
import repository.BaseRepository;
import repository.ICustomerRepository;
import service.ICustomerService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private final String SELECT_ALL = "select c.*, ct.name as name_type from customer c join customer_type ct on c.customer_type_id=ct.id ;";
    private final String FIND_NAME_ADDRESS = "select c.*, ct.name as name_type from customer c join customer_type ct on c.customer_type_id=ct.id where c.name like ? and c.address like ?;";
    private final String DELETE_CUSTOMER = "delete  from customer where id = ?;";

    @Override
    public List<Customer> listCustomer() {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String address = resultSet.getString("address");
                String email = resultSet.getString("email");
                String nameType = resultSet.getString("name_type");
                CustomerType customerType = new CustomerType(id, nameType);
                Customer customer = new Customer(id, name, dateOfBirth, gender, idCard, phoneNumber, address, email, customerType);
                customerList.add(customer);
            }
        } catch (SQLException throwables) {

            throwables.printStackTrace();
        }

        return customerList;
    }

    @Override
    public void create(Customer customer) {

    }

    @Override
    public boolean update(Customer customer) {
        return false;
    }

    @Override
    public boolean delete(int id) {
        boolean rowDelete;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(DELETE_CUSTOMER);
            ps.setInt(1, id);
            rowDelete = ps.executeUpdate() > 0;
            return rowDelete;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<Customer> findCustomer(String name, String address) {
        List<Customer> customerList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_NAME_ADDRESS);
            ps.setString(1, "%" + name + "%");
            ps.setString(2, "%" + address + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String nameFind = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                boolean gender = resultSet.getBoolean("gender");
                String idCard = resultSet.getString("id_card");
                String phoneNumber = resultSet.getString("phone_number");
                String addressFind = resultSet.getString("address");
                String email = resultSet.getString("email");
                String nameType = resultSet.getString("name_type");
                CustomerType customerType = new CustomerType(id, nameType);
                Customer customer = new Customer(id, nameFind, dateOfBirth, gender, idCard, phoneNumber, addressFind, email, customerType);
                customerList.add(customer);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
