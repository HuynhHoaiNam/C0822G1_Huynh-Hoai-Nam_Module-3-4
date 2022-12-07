package controller;

import model.facility.Facility;
import service.facilityService.IFacilityService;
import service.facilityService.impl.FacilityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FacilityServlet", urlPatterns = "/facility")
public class FacilityServlet extends HttpServlet {
    private IFacilityService facilityService = new FacilityService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                create(request, response);
                break;
            case "update":
                break;
            case "delete":
                break;
            case "search":
                showSearch(request, response);
                break;
        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        int area = Integer.parseInt(request.getParameter("area"));
        double cost = Double.parseDouble(request.getParameter("cost"));
        int maxPeople = Integer.parseInt(request.getParameter("maxPeople"));
        String standardRoom = request.getParameter("standardRoom");
        String descriptionOtherConvenience = request.getParameter("standardRoom");
        double poolArea = Double.parseDouble(request.getParameter("descriptionOtherConvenience"));
        int numberOfFloors = Integer.parseInt(request.getParameter("numberOfFloors"));
        String facilityFree = request.getParameter("name");
        int rentTypeId = Integer.parseInt(request.getParameter("name"));
        int facilityTypeId = Integer.parseInt(request.getParameter("name"));
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
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                break;
            case "update":
                break;
            case "delete":
                break;
            default:
                showFacility(request, response);
                break;
        }
    }

    private void showFacility(HttpServletRequest request, HttpServletResponse response) {
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
