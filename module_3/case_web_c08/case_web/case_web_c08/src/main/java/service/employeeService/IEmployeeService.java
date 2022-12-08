package service.employeeService;

import model.employee.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> selectAllEmployee();

    boolean createE(Employee employee);

    boolean updateE(Employee employee);

    boolean deleteE(int id);

    List<Employee> findE(String name, String userName);
}
