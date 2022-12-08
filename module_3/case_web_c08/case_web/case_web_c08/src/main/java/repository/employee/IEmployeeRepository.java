package repository.employee;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeRepository {
    List<Employee> selectAllEmployee();

    boolean createE(Employee employee);

    boolean updateE(Employee employee);

    boolean deleteE(int id);

    List<Employee> findE(String name, String userName);
}
