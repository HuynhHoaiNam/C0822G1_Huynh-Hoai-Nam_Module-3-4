package service.employeeService;

import model.employee.Division;
import model.employee.Position;

import java.util.List;

public interface IDivisionService {
    List<Division> selectAllDivision();
}
