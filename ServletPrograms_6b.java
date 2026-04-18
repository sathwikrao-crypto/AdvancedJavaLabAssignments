//Build a servlet program to create a cookie to get your name through text box and press submit button( through HTML) to display the message by greeting Welcome back your name ! , you have visited this page n times ( n = number of your visit ) and demonstrate the expiry of cookie also.


import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ServletPrograms_6b")
public class ServletPrograms_6b extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get name from request parameter
        String name = request.getParameter("userName");

        // Retrieve cookies
        Cookie[] cookies = request.getCookies();
        String existingUser = null;
        int visitCount = 0;

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userName")) {
                    existingUser = cookie.getValue();
                }
                if (cookie.getName().equals("visitCount")) {
                    visitCount = Integer.parseInt(cookie.getValue());
                }
            }
        }

        // If new user, set name from textbox
        if (existingUser == null && name != null && !name.isEmpty()) {
            existingUser = name;
        }

        // Increment visit count
        if (existingUser != null) {
            visitCount++;
        }

        // Create/Update cookies
        if (existingUser != null) {
            Cookie nameCookie = new Cookie("userName", existingUser);
            Cookie visitCookie = new Cookie("visitCount", String.valueOf(visitCount));

            // Cookie expires in 60 seconds (demo)
            nameCookie.setMaxAge(60);
            visitCookie.setMaxAge(60);

            response.addCookie(nameCookie);
            response.addCookie(visitCookie);
        }

        // Output greeting
        out.println("<html><body>");
        if (existingUser != null) {
            out.println("<h2>Welcome back " + existingUser + "!</h2>");
            out.println("<p>You have visited this page " + visitCount + " times.</p>");
            out.println("<p>(Cookie will expire in 60 seconds)</p>");
            out.println("<form action='ServletPrograms_6b' method='post'>");
            out.println("<input type='submit' value='Logout'>");
            out.println("</form>");
        } else {
            // Show form if no name yet
            out.println("<h2>Welcome Guest! Please login first time</h2>");
            out.println("<form action='ServletPrograms_6b' method='get'>");
            out.println("Enter your name: <input type='text' name='userName'>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");
        }
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Delete cookies by setting max age to 0
        Cookie userCookie = new Cookie("userName", "");
        userCookie.setMaxAge(0);
        response.addCookie(userCookie);

        Cookie visitCookie = new Cookie("visitCount", "");
        visitCookie.setMaxAge(0);
        response.addCookie(visitCookie);

        // Redirect back to servlet
        response.sendRedirect("ServletPrograms_6b");
    }
}