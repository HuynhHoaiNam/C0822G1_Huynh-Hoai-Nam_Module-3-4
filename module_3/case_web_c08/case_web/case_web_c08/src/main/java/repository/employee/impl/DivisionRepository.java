package repository.employee.impl;

import model.employee.Division;
import repository.customer.BaseRepository;
import repository.employee.IDivisionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DivisionRepository implements IDivisionRepository {
    private final String SELECT_ALL_DIVISION = "select * from devision;";

    @Override
    public List<Division> selectAllDivision() {
        List<Division> divisionList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_DIVISION);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Division division = new Division(id, name);
                divisionList.add(division);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionList;
    }
}
