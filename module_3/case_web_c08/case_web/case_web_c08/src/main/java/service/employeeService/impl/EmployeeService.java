package service.employeeService.impl;

import model.employee.Employee;
import repository.employee.IEmployeeRepository;
import repository.employee.impl.EmployeeRepository;
import service.employeeService.IEmployeeService;

import java.util.List;

public class EmployeeService implements IEmployeeService {
    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public List<Employee> selectAllEmployee() {
        return employeeRepository.selectAllEmployee();
    }

    @Override
    public boolean createE(Employee employee) {
        return employeeRepository.createE(employee);
    }

    @Override
    public boolean updateE(Employee employee) {
        return employeeRepository.updateE(employee);
    }

    @Override
    public boolean deleteE(int id) {
        return employeeRepository.deleteE(id);
    }

    @Override
    public List<Employee> findE(String name, String userName) {
        return employeeRepository.findE(name, userName);
    }
}
