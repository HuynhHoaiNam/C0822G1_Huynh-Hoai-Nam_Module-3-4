package repository.employee.impl;

import model.employee.Position;
import repository.customer.BaseRepository;
import repository.employee.IPositionRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PositionRepository implements IPositionRepository {
    private final String SELECT_ALL_POSITION = "select * from position;";

    @Override
    public List<Position> selectAllPosition() {
        List<Position> positionList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_POSITION);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                Position position = new Position(id, name);
                positionList.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }
}
