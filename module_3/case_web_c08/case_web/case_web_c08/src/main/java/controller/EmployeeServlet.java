package controller;

import model.employee.Division;
import model.employee.EducationDegree;
import model.employee.Employee;
import model.employee.Position;
import model.facility.FacilityType;
import service.employeeService.IDivisionService;
import service.employeeService.IEducationDegreeService;
import service.employeeService.IEmployeeService;
import service.employeeService.IPositionService;
import service.employeeService.impl.DivisionService;
import service.employeeService.impl.EducationService;
import service.employeeService.impl.EmployeeService;
import service.employeeService.impl.PositionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    private IEmployeeService employeeService = new EmployeeService();
    private IDivisionService divisionService = new DivisionService();
    private IEducationDegreeService educationDegreeService = new EducationService();
    private IPositionService positionService = new PositionService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "delete":
                delete(request, response);
                break;
            case "update":
                update(request,response);
                break;
            case "search":
                showSearch(request, response);
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionName"));
        int educationId = Integer.parseInt(request.getParameter("educationName"));
        int divisionId = Integer.parseInt(request.getParameter("divisionName"));
        Employee employee = new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, positionId, educationId, divisionId);
        boolean check = employeeService.updateE(employee);
        String mess = "Chỉnh Sửa Thành Công";
        if (!check) {
            mess = "Chỉnh Sửa Thất Bại";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        request.setAttribute("name", name);
        String address = request.getParameter("address");
        request.setAttribute("address", address);
        List<Employee> employeeList = employeeService.findE(name, address);
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        employeeService.deleteE(id);
        showListEmployee(request, response);

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String idCard = request.getParameter("idCard");
        double salary = Double.parseDouble(request.getParameter("salary"));
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int positionId = Integer.parseInt(request.getParameter("positionName"));
        int educationId = Integer.parseInt(request.getParameter("educationName"));
        int divisionId = Integer.parseInt(request.getParameter("divisionName"));
        Employee employee = new Employee(id, name, dateOfBirth, idCard, salary, phoneNumber, email, address, positionId, educationId, divisionId);
        boolean check = employeeService.createE(employee);
        String mess = "Thêm Mới Thành Công";
        if (!check) {
            mess = "Thêm Mới Thất Bại";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
//                createShow(request, response);
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                showListEmployee(request, response);
                break;
        }
    }

//    private void createShow(HttpServletRequest request, HttpServletResponse response) {
//        List<Employee> employeeList = employeeService.selectAllEmployee();
//        request.setAttribute("employeeList", employeeList);
//        List<Position> positionList = positionService.selectAllPosition();
//        request.setAttribute("positionList", positionList);
//        List<Division> divisionList = divisionService.selectAllDivision();
//        request.setAttribute("divisionList", divisionList);
//        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducation();
//        request.setAttribute("educationDegreeList", educationDegreeList);
//        request.getRequestDispatcher("");
//    }

    private void showListEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<Employee> employeeList = employeeService.selectAllEmployee();
        positionService.selectAllPosition();
        List<Position> positionList = positionService.selectAllPosition();
        request.setAttribute("positionList", positionList);
        List<Division> divisionList = divisionService.selectAllDivision();
        request.setAttribute("divisionList", divisionList);
        List<EducationDegree> educationDegreeList = educationDegreeService.selectAllEducation();
        request.setAttribute("educationDegreeList", educationDegreeList);
        request.setAttribute("employeeList", employeeList);
        try {
            request.getRequestDispatcher("/view/employee/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
