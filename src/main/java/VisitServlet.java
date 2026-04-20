import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/VisitServlet")
public class VisitServlet extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        // 1. Get user name from form or existing cookies
        String userName = request.getParameter("userName");
        Cookie[] cookies = request.getCookies();
        
        int visitCount = 0;
        String savedName = "";

        // 2. Scan existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                }
                if (c.getName().equals("savedName")) {
                    savedName = c.getValue();
                }
            }
        }

        // 3. Logic: If form is submitted, use that name. Otherwise use saved name.
        if (userName == null || userName.isEmpty()) {
            userName = savedName;
        }
        
        // Increment visit count
        visitCount++;

        // 4. Create and Configure Cookies
        // Cookie for Name: Expires in 60 seconds (Short-lived for demonstration)
        Cookie nameCookie = new Cookie("savedName", userName);
        nameCookie.setMaxAge(60); 
        
        // Cookie for Visit Count: Expires in 24 hours
        Cookie countCookie = new Cookie("visitCount", String.valueOf(visitCount));
        countCookie.setMaxAge(24 * 60 * 60);

        // Add cookies to response
        response.addCookie(nameCookie);
        response.addCookie(countCookie);

        // 5. Display Information
        out.println("<html><body style='font-family: sans-serif;'>");
        out.println("<h2>Welcome back, " + userName + "!</h2>");
        out.println("<p>You have visited this page <b>" + visitCount + "</b> times.</p>");
        
        out.println("<div style='background: #f4f4f4; padding: 10px; border-left: 5px solid #2196F3;'>");
        out.println("<strong>Expiry Demonstration:</strong><br>");
        out.println("The 'savedName' cookie is set to expire in <b>60 seconds</b>.<br>");
        out.println("If you refresh after 1 minute, the name will disappear, but the visit count will remain!");
        out.println("</div>");

        out.println("<h3>Active Cookie List & Values:</h3>");
        out.println("<table border='1' cellpadding='10'><tr><th>Cookie Name</th><th>Value</th></tr>");
        
        if (cookies != null) {
            for (Cookie c : cookies) {
                out.println("<tr><td>" + c.getName() + "</td><td>" + c.getValue() + "</td></tr>");
            }
        } else {
            out.println("<tr><td colspan='2'>No cookies sent in this request.</td></tr>");
        }
        out.println("</table>");
        
        out.println("<br><a href='VisitServlet'>Refresh Page to Increase Count</a>");
        out.println("<br><br><a href='index.html'>Back to Form</a>");
        out.println("</body></html>");
    }

    // Handle GET requests (Refresh) the same way as POST
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}