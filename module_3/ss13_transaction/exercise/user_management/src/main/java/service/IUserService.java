package service;

import model.User;

import java.util.List;

public interface IUserService {
    List<User> selectAll();

    boolean create(User user);

    boolean update(User user);

    boolean delete(int id);

    List<User> findCountry(String country);
}
