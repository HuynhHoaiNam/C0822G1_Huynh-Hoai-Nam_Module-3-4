package controller;

import model.facility.Facility;
import model.facility.FacilityType;
import model.facility.RentType;
import service.facilityService.IFacilityService;
import service.facilityService.IFacilityTypeService;
import service.facilityService.IRentTypeService;
import service.facilityService.impl.FacilityService;
import service.facilityService.impl.FacilityTypeService;
import service.facilityService.impl.RentTypeService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "FacilityServlet", urlPatterns = "/facility")
public class FacilityServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityService();
    private IFacilityTypeService facilityTypeService = new FacilityTypeService();
    private IRentTypeService rentTypeService = new RentTypeService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                update(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "search":
                showSearch(request, response);
                break;
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("standardRoom");
        double poolArea = Double.parseDouble(request.getParameter("descriptionOtherConvenience"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        String facilityFree = request.getParameter("facilityFree");
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));
        Facility facility = new Facility(name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, descriptionOtherConvenience, poolArea,
                numberOfFloors, facilityFree);
        boolean check = facilityService.updateF(facility);
        String mess = "Chỉnh Sửa Thành Công";
        if (!check) {
            mess = "Chỉnh Sửa Thất Bại";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("/view/facility/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        facilityService.deleteF(id);
        showFacility(request, response);
    }


    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("descriptionOtherConvenience");
        Double poolArea;
        if (request.getParameter("poolArea") == null) {
            poolArea = null;
        } else {
            poolArea = Double.parseDouble(request.getParameter("poolArea"));
        }
        Integer numberOfFloors;
        if (request.getParameter("numberOfFloors") == null) {
            numberOfFloors = null;
        } else {
            numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        }
        String facilityFree = request.getParameter("facilityFree");
        int rentTypeId = Integer.parseInt(request.getParameter("rentTypeId"));
        int facilityTypeId = Integer.parseInt(request.getParameter("facilityTypeId"));
        Facility facility = new Facility(name, area, cost, maxPeople, rentTypeId, facilityTypeId, standardRoom, descriptionOtherConvenience, poolArea, numberOfFloors, facilityFree);
        boolean check = facilityService.createF(facility);
        String mess = "Thêm Mới Thành Công";
        if (!check) {
            mess = "Thêm Mới Thất Bại";
        }
        request.setAttribute("mess", mess);
        try {
            request.getRequestDispatcher("/view/facility/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        String facilityName = request.getParameter("facilityName");
        String standardRoomFind = request.getParameter("maxPeople");
        List<Facility> facilityList = facilityService.findManyField(facilityName, standardRoomFind);
        request.setAttribute("facilityList", facilityList);
        try {
            request.getRequestDispatcher("/view/facility/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreate(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
            default:
                showFacility(request, response);
                break;
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        List<Facility> facilityList = facilityService.findById(id);
        request.setAttribute("facilityList", facilityList);
        List<FacilityType> facilityTypeList = facilityTypeService.selectF();
        request.setAttribute("facilityTypeList", facilityTypeList);
        List<RentType> rentTypeList = rentTypeService.selectAllR();
        request.setAttribute("rentTypeList", rentTypeList);
        try {
            request.getRequestDispatcher("/view/facility/update.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        List<FacilityType> facilityTypeList= facilityTypeService.selectF();
        request.setAttribute("facilityTypeList",facilityTypeList);
        List<RentType> rentTypeList=rentTypeService.selectAllR();
        request.setAttribute("rentTypeList",rentTypeList);
        List<Facility>facilityList=facilityService.selectAll();
        request.setAttribute("facilityList",facilityList);
        try {
            request.getRequestDispatcher("/view/facility/create_test.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showFacility(HttpServletRequest request, HttpServletResponse response) {
        List<FacilityType> facilityTypeList = facilityTypeService.selectF();
        request.setAttribute("facilityTypeList", facilityTypeList);
        List<Facility> facilityList = facilityService.selectAll();
        request.setAttribute("facilityList", facilityList);
        try {
            request.getRequestDispatcher("/view/facility/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
