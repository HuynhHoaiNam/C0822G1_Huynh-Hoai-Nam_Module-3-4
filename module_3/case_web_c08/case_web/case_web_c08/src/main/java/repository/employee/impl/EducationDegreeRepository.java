package repository.employee.impl;

import model.employee.EducationDegree;
import repository.customer.BaseRepository;
import repository.employee.IEducationDegreeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EducationDegreeRepository implements IEducationDegreeRepository {
    private final String SELECT_ALL_EDU = "select * from education_degree;";

    @Override
    public List<EducationDegree> selectAllEducation() {
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_EDU);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                EducationDegree educationDegree = new EducationDegree(id, name);
                educationDegreeList.add(educationDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegreeList;
    }
}
