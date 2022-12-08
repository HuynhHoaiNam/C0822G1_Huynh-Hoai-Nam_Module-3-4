package service.employeeService.impl;

import model.employee.Division;
import model.employee.Position;
import repository.employee.IDivisionRepository;
import repository.employee.impl.DivisionRepository;
import service.employeeService.IDivisionService;

import java.util.List;

public class DivisionService implements IDivisionService {
    private IDivisionRepository divisionRepository= new DivisionRepository();
    @Override
    public List<Division> selectAllDivision() {
        return divisionRepository.selectAllDivision();
    }
}
