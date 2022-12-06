package repository.impl;

import model.User;
import repository.BaseRepository;
import repository.IUserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository {
    private final String SELECT_ALL = "call p_select;";
    private final String INSERT_INTO = "insert into users(name,email,country)values(?,?,?);";
    private final String FIND_BY_COUNTRY = "select*from users where country like ?;";
    private final String UPDATE_USER = "call p_update(?,?,?,?);";
    private final String DELETE_USER = "call p_delete(?);";

    @Override
    public List<User> selectAll() {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            CallableStatement cl = connection.prepareCall(SELECT_ALL);
            ResultSet resultSet = cl.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String country = resultSet.getString("country");
                User user = new User(id, name, email, country);
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return userList;
    }

    @Override
    public boolean create(User user) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(INSERT_INTO);
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getCountry());
            return ps.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean update(User user) {
        Connection connection = BaseRepository.getConnectDB();
        boolean rowUpdated;
        try {
            CallableStatement cl = connection.prepareCall(UPDATE_USER);
//            statement.setInt(1, user.getId());
            cl.setString(1, user.getName());
            cl.setString(2, user.getEmail());
            cl.setString(3, user.getCountry());
            cl.setInt(4, user.getId());
            rowUpdated = cl.executeUpdate() > 0;
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
            CallableStatement cl = connection.prepareCall(DELETE_USER);
            cl.setInt(1, id);
            rowDelete = cl.executeUpdate() > 0;
            return rowDelete;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public List<User> findCountry(String country) {
        List<User> userList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BY_COUNTRY);
            ps.setString(1, "%" + country + "%");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String countryInput = resultSet.getString("country");
                User user = new User(id, name, email, countryInput);
                userList.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
}
