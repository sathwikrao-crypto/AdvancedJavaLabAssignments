import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ResultServlet")
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        try {
            // 1. Retrieve Data
            String rollNo = request.getParameter("rollNo");
            String name = request.getParameter("sName");
            int m1 = Integer.parseInt(request.getParameter("m1"));
            int m2 = Integer.parseInt(request.getParameter("m2"));
            int m3 = Integer.parseInt(request.getParameter("m3"));
            int m4 = Integer.parseInt(request.getParameter("m4"));
            int m5 = Integer.parseInt(request.getParameter("m5"));

            // 2. Server-Sided Validation
            if (m1 < 0 || m1 > 100 || m2 < 0 || m2 > 100 || m3 < 0 || m3 > 100 || m4 < 0 || m4 > 100 || m5 < 0 || m5 > 100) {
                request.setAttribute("error", "Invalid marks provided. Must be 0-100.");
                request.getRequestDispatcher("index.jsp").forward(request, response);
                return;
            }

            // 3. Logic: Calculate Average and Result
            double avg = (m1 + m2 + m3 + m4 + m5) / 5.0;
            String status = (m1 >= 40 && m2 >= 40 && m3 >= 40 && m4 >= 40 && m5 >= 40) ? "PASS" : "FAIL";

            // 4. Set Attributes for JSP
            request.setAttribute("rollNo", rollNo);
            request.setAttribute("sName", name);
            request.setAttribute("avg", avg);
            request.setAttribute("status", status);
            request.setAttribute("marks", new int[]{m1, m2, m3, m4, m5});

            // 5. Forward to result.jsp
            RequestDispatcher rd = request.getRequestDispatcher("result.jsp");
            rd.forward(request, response);

        } catch (NumberFormatException e) {
            response.sendRedirect("index.jsp");
        }
    }
}