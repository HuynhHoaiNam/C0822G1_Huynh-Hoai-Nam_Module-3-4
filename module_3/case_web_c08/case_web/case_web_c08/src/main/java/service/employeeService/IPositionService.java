package service.employeeService;

import model.employee.Position;

import java.util.List;

public interface IPositionService {
    List<Position> selectAllPosition();
}
