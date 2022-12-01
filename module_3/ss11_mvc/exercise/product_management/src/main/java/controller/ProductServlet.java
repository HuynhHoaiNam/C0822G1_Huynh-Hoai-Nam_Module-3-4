package controller;

import model.Product;
import repository.impl.ProductRepository;
import service.impl.ProductService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {
    //    private static List<Product> productList = new ArrayList<>();
    private ProductService productService = new ProductService();


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
            case "delete":
                delete(request, response);
                break;
        }
    }

    private void delete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            this.productService.remove(id);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void update(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String producer = request.getParameter("producer");
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            product.setId(id);
            product.setName(name);
            product.setPrice(price);
            product.setDescribe(describe);
            product.setProducer(producer);
//             request.setAttribute("product",product);
            request.setAttribute("mess", "Update Thành Công");
            try {
                request.getRequestDispatcher("view/product/edit.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    private void create(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        double price = Double.parseDouble(request.getParameter("price"));
        String describe = request.getParameter("describe");
        String producer = request.getParameter("producer");
        Product product = new Product(id, name, price, describe, producer);
        productService.create(product);
        showList(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "update":
                showFormUpdate(request, response);
                break;
            case "delete":
                showDelete(request, response);
                break;
            case "search":
                showSearch(request, response);
                break;
            case "properties":
                showAllProperties(request, response);
                break;
            default:
                showList(request, response);
                break;
        }
    }

    private void showAllProperties(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.selectAll();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("/view/product/list_properties.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showList(HttpServletRequest request, HttpServletResponse response) {
        List<Product> productList = productService.selectAll();
        request.setAttribute("productList", productList);
        try {
            request.getRequestDispatcher("/view/product/list.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void showSearch(HttpServletRequest request, HttpServletResponse response) {
        String name=request.getParameter("nameInput");
       Product product= productService.findByName(name);
        request.setAttribute("product",product);
        try {
            request.getRequestDispatcher("/view/product/search.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showDelete(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            try {
                request.getRequestDispatcher("view/product/delete.jsp").forward(request, response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showFormUpdate(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productService.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        }else {
            request.setAttribute("product",product);
            try {
                request.getRequestDispatcher("view/product/edit.jsp").forward(request,response);
            } catch (ServletException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void showFormCreate(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/view/product/create.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
