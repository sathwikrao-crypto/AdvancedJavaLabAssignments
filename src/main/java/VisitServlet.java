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
        
        String inputName = request.getParameter("userName");
        Cookie[] cookies = request.getCookies();
        
        int visitCount = 0;
        String nameFromCookie = "";

        // Look for existing cookies
        if (cookies != null) {
            for (Cookie c : cookies) {
                if (c.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(c.getValue());
                }
                if (c.getName().equals("savedName")) {
                    nameFromCookie = c.getValue();
                }
            }
        }

        // Increment visit count
        visitCount++;
        
        // If user submitted a new name, use it; otherwise use the one from cookie
        String displayName = (inputName != null && !inputName.isEmpty()) ? inputName : nameFromCookie;

        // Create/Update Cookies
        Cookie cName = new Cookie("savedName", displayName);
        Cookie cCount = new Cookie("visitCount", String.valueOf(visitCount));

        // DEMONSTRATING EXPIRY:
        // Name cookie expires in 60 seconds (Short-lived)
        cName.setMaxAge(60); 
        // Count cookie expires in 24 hours
        cCount.setMaxAge(24 * 60 * 60); 

        response.addCookie(cName);
        response.addCookie(cCount);

        // Display results
        out.println("<html><body>");
        out.println("<h1>Welcome back, " + displayName + "!</h1>");
        out.println("<h3>You have visited this page " + visitCount + " times.</h3>");
        
        out.println("<p><i>Note: The 'Name' cookie will expire in 60 seconds for demonstration.</i></p>");
        
        out.println("<h4>Current Active Cookies:</h4>");
        out.println("<table border='1'><tr><th>Name</th><th>Value</th><th>Max Age</th></tr>");
        
        // Re-fetch cookies to show the list
        for (Cookie c : cookies != null ? cookies : new Cookie[0]) {
            out.println("<tr><td>" + c.getName() + "</td><td>" + c.getValue() + "</td><td>" + c.getMaxAge() + "</td></tr>");
        }
        
        out.println("</table>");
        out.println("<br><a href='index.html'>Go Back</a>");
        out.println("</body></html>");
    }

    // Handle GET requests by calling doPost so the page works on refresh
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        doPost(request, response);
    }
}