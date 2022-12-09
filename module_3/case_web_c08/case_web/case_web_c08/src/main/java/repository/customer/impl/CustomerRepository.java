package repository.customer.impl;

import model.customer.Customer;
import model.customer.CustomerType;
import repository.customer.BaseRepository;
import repository.customer.ICustomerRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private final String SELECT_ALL = "select c.*, ct.name as name_type from customer c join customer_type ct on c.customer_type_id=ct.id ;";
    private final String FIND_BY_ID = "select c.*, ct.name as name_type from customer c join customer_type ct on c.customer_type_id=ct.id where c.id=?;";
    private final String FIND_NAME_ADDRESS = "select c.*, ct.name as name_type from customer c join customer_type ct on c.customer_type_id=ct.id where c.name like ? and c.address like ?;";
    private final String DELETE_CUSTOMER = "delete  from customer where id = ?;";
    private final String CREATE_CUSTOMER = "INSERT INTO customer ( `name`, date_of_birth, gender, id_card, phone_number, address, email, customer_type_id)" +
            "VALUES (?,?,?,?,?,?,?,?);";
    private final String UPDATE_CUSTOMER = "update customer set name = ?, date_of_birth=?,gender=?, id_card=?,phone_number=?, address=?, email=?, customer_type_id=? where id=?;";


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
    public boolean create(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(CREATE_CUSTOMER);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getDateOfBirth());
            ps.setBoolean(3, customer.isGender());
            ps.setString(4, customer.getIdCard());
            ps.setString(5, customer.getPhoneNumber());
            ps.setString(6, customer.getAddress());
            ps.setString(7, customer.getEmail());
            ps.setInt(8, customer.getCustomerTypeId());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(Customer customer) {
        Connection connection = BaseRepository.getConnectDB();
        boolean rowUpdated;
        try {
            PreparedStatement ps = connection.prepareStatement(UPDATE_CUSTOMER);
            ps.setString(1, customer.getName());
            ps.setString(2, customer.getDateOfBirth());
            ps.setBoolean(3, customer.isGender());
            ps.setString(4, customer.getIdCard());
            ps.setString(5, customer.getPhoneNumber());
            ps.setString(6, customer.getAddress());
            ps.setString(7, customer.getEmail());
            ps.setInt(8, customer.getCustomerTypeId());
            ps.setInt(9,customer.getId());
            rowUpdated = ps.executeUpdate() > 0;
            return rowUpdated;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
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

    @Override
    public Customer findById(int id) {
        Customer customer = null;
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
                while (resultSet.next()) {
                    int idFind = resultSet.getInt("id");
                    String name = resultSet.getString("name");
                    String dateOfBirth = resultSet.getString("date_of_birth");
                    boolean gender = resultSet.getBoolean("gender");
                    String idCard = resultSet.getString("id_card");
                    String phoneNumber = resultSet.getString("phone_number");
                    String addressFind = resultSet.getString("address");
                    String email = resultSet.getString("email");
                    String nameType = resultSet.getString("name_type");
                    int customerTypeId= resultSet.getInt("customer_type_id");
                    CustomerType customerType = new CustomerType(customerTypeId, nameType);
                     customer = new Customer(idFind, name, dateOfBirth, gender, idCard, phoneNumber, addressFind, email, customerType);
                }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customer;
    }
}
