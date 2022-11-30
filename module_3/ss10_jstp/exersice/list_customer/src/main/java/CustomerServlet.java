import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {

    private static List<Customer> customerList = new ArrayList<>();

    static {
        customerList.add(new Customer(1, "Nam Blue", "26/05/2004", "Tuyên Quang", "https://i.pinimg.com/474x/90/57/0a/90570addee2645866a597530721f37fd.jpg"));
        customerList.add(new Customer(2, "Long", "02/05/1999", "New York", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcR9AkzidV3oevjUVnPm4rtNcpA-rdEUVdY4At4v5Y2dZw6VCLDhILbOTElHJFvHl5J6BlM&usqp=CAU"));
        customerList.add(new Customer(3, "Quang", "12/03/1980", "Hồng Kông", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQaByfIs4nHyA2RZ3pFRA4UdIT7xIUIUBSEg_YZJ8pPEFxVoG62MJHlXef-C9XpnXw8r-M&usqp=CAU"));
        customerList.add(new Customer(4, "Ahihi", "20/11/2004", "Tokyo", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQIFFSoVn5hGCJwT9RhooklzWW2jwmDQVUQstcSQbfT7Anx9uUcYFHmA5cBetxVPBjZpRw&usqp=CAU"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customerList", customerList);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
