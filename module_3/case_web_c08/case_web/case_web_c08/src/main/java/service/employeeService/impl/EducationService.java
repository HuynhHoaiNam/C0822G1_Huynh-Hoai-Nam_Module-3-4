package service.employeeService.impl;

import model.employee.EducationDegree;
import repository.employee.IEducationDegreeRepository;
import repository.employee.impl.EducationDegreeRepository;
import service.employeeService.IEducationDegreeService;

import java.util.List;

public class EducationService implements IEducationDegreeService {
    private IEducationDegreeRepository educationDegreeRepository = new EducationDegreeRepository();

    @Override
    public List<EducationDegree> selectAllEducation() {
        return educationDegreeRepository.selectAllEducation();
    }
}
