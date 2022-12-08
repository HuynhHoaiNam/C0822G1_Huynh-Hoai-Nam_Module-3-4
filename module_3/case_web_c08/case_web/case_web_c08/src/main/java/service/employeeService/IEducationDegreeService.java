package service.employeeService;

import model.employee.EducationDegree;

import java.util.List;

public interface IEducationDegreeService {
    List<EducationDegree> selectAllEducation();
}
