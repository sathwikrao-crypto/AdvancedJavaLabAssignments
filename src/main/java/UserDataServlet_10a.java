import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/processUser")
public class UserDataServlet_10a extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String designation = request.getParameter("designation");
        
        // Logical processing
        request.setAttribute("username", username);
        request.setAttribute("email", email);
        request.setAttribute("designation", designation);
        request.setAttribute("message", "User data processed successfully");
        
        // Forwarding to the JSP file
        RequestDispatcher dispatcher = request.getRequestDispatcher("result.jsp");
        dispatcher.forward(request, response);
    }
}