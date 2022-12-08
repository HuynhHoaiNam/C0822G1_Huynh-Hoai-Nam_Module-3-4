package repository.employee.impl;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import repository.customer.BaseRepository;
import repository.employee.IEmployeeRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {
    private final String SELECT_ALL_EMPLOYEE = "select e.*,p.name as position_name , d.name as division_name, ed.name as education_name  from position p\n" +
            "join employee e on e.position_id=p.id\n" +
            "join education_degree ed on ed.id=e.education_degree_id\n" +
            "join devision d on e.education_degree_id=d.id;";

    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement ps = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String idCard = resultSet.getString("id_card");
                double salary = resultSet.getDouble("salary");
                String phoneNumber = resultSet.getString("phone_number");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                int positionId = resultSet.getInt("position_id");
                int educationDegreeId = resultSet.getInt("education_degree_id");
                int divisionId = resultSet.getInt("devision_id");
                String namePosition=resultSet.getString("position_name");
                Position position= new Position(positionId,namePosition);
                String nameDivision=resultSet.getString("division_name");
                Division division= new Division(divisionId,nameDivision);
                String nameEducation = resultSet.getString("education_name");
                EducationDegree educationDegree= new EducationDegree(educationDegreeId,nameEducation);
                Employee employee = new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, position,educationDegree,division);
                employeeList.add(employee);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeList;
    }

    @Override
    public boolean createE(Employee employee) {
        return false;
    }

    @Override
    public boolean updateE(Employee employee) {
        return false;
    }

    @Override
    public boolean deleteE(int id) {
        return false;
    }

    @Override
    public List<Employee> findE(String name, String userName) {
        return null;
    }
}
