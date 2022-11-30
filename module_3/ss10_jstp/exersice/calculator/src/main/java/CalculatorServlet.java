import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/calculator")
public class CalculatorServlet extends HttpServlet {
    private Calculator calculator = new Calculator();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double numberFist = Integer.parseInt(request.getParameter("numberFist"));
        request.setAttribute("numberFist",numberFist);
        String operator = request.getParameter("operator");
        request.setAttribute("operator",operator);
        double numberSecond = Integer.parseInt(request.getParameter("numberSecond"));
        request.setAttribute("numberSecond",numberSecond);
        double result = Calculator.MethodCalculation(numberFist, operator, numberSecond);
        request.setAttribute("result", result);
        request.getRequestDispatcher("result.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


}