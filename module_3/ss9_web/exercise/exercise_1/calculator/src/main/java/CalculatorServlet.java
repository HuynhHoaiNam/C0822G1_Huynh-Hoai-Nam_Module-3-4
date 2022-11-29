import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double valueFirst = Double.parseDouble(request.getParameter("ListPrice"));
        double valueSecond = Double.parseDouble(request.getParameter("DiscountPercent"));
        double result = valueFirst * valueSecond * 0.01;
        request.setAttribute("result", result);
        String describe = request.getParameter("Describe");
        request.setAttribute("describe",describe);
//        request.getRequestDispatcher("result.jsp").forward(request, response);
        request.getRequestDispatcher("result.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
