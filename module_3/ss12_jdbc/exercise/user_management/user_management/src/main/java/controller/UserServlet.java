package controller;

import model.User;
import service.IUserService;
import service.impl.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserServlet", urlPatterns = "/user")
public class UserServlet extends HttpServlet {
    private IUserService userService = new UserService();

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
                update(request, response);
                break;
            case "search":
                showSearch(request, response);
                break;
        }
    }

    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        String countryInput = request.getParameter("countryInput");
        request.setAttribute("countryInput",countryInput);
        List<User> userList = userService.findCountry(countryInput);
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");

        User user = new User(id, name, email, country);
        if (userService.update(user)){
            request.setAttribute("mess","ok");
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/edit.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
//        List<User> userList= new ArrayList<>();
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String country = request.getParameter("country");
        User user = new User(name, email, country);
        boolean check = userService.create(user);
        String mess = "Thêm Mới Thành Công";
        if (!check) {
            mess = "Thêm Mới Không Thành Công";
        }
        request.setAttribute("mess", mess);
        showCreate(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
            case "delete":
                showDelete(request, response);
                break;
//            case "search":
//                showSearch(request, response);
//                break;
            default:
                showList(request, response);
                break;
        }
    }

//    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
//        String countryInput = request.getParameter("countryInput");
//        request.setAttribute("countryInput",countryInput);
//        List<User> userList = userService.findCountry(countryInput);
//        request.setAttribute("userList", userList);
//        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
//        try {
//            dispatcher.forward(request, response);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<User> userList = userService.selectAll();
        request.setAttribute("userList", userList);
        try {
            request.getRequestDispatcher("view/user/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        userService.delete(id);

        List<User> userList = userService.selectAll();
        request.setAttribute("userList", userList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/user/list.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/user/edit").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("view/user/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
