// Build a servlet program to check the given number is prime number or not using HTML with step by step procedure.


import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/primeChecker")
public class Servletprogram_6c extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Servletprogram_6c() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String numberStr = request.getParameter("numberInput");
        int number;
        String message;

        try {
            number = Integer.parseInt(numberStr);

            if (number < 0) {
                message = "Please enter a non-negative number.";
            } else if (number == 0 || number == 1) {
                message = number + " is neither prime nor composite.";
            } else if (isNumberPrime(number)) {
                message = number + " is a prime number.";
            } else {
                message = number + " is not a prime number.";
            }
        } catch (NumberFormatException e) {
            message = "Invalid input. Please enter a valid integer.";
        }

        // HTML response to display the result
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Prime Number Result</title>");
        out.println("<style>");
        out.println("    body { font-family: Arial, sans-serif; margin: 20px; }");
        out.println("    .result-box { border: 1px solid #ccc; padding: 20px; border-radius: 5px; background-color: #f9f9f9; width: 300px; text-align: center; margin-top: 20px;}");
        out.println("    .prime { color: green; font-weight: bold; }");
        out.println("    .not-prime { color: red; font-weight: bold; }");
        out.println("    a { text-decoration: none; background-color: #007bff; color: white; padding: 8px 15px; border-radius: 3px; display: inline-block; margin-top: 15px; }");
        out.println("    a:hover { background-color: #0056b3; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("    <div class=\"result-box\">");
        out.println("        <h3>Result:</h3>");
        
        // Apply class based on prime status for styling
        if (message.contains("prime number.")) {
            out.println("        <p class=\"prime\">" + message + "</p>");
        } else if (message.contains("not a prime number.")) {
            out.println("        <p class=\"not-prime\">" + message + "</p>");
        } else {
            out.println("        <p>" + message + "</p>");
        }
        
        out.println("        <a href=\"index.html\">Check Another Number</a>");
        out.println("    </div>");
        out.println("</body>");
        out.println("</html>");

        out.close();
    }

    /**
     * Helper method to check if a number is prime.
     * Assumes number >= 2.
     */
    private boolean isNumberPrime(int num) {
        if (num <= 1) { // Numbers less than or equal to 1 are not prime by definition
            return false;
        }
        // Loop from 2 to sqrt(num)
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false; // Found a divisor, so it's not prime
            }
        }
        return true; // No divisors found, so it's prime
    }
}
