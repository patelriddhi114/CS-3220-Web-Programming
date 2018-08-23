package sessions;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.User;

@WebServlet("/sessions/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// Set the content type to HTML
		response.setContentType("text/html");
		
		// Get a Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate the template HTML
		out.println("<!DOCTYPE html>");		
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		out.println("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println("        <title>Login</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		if (request.getAttribute("error") != null)
			out.println("<p class=\"text-danger\">Invalid Username and/or Password</p>");
		
		out.println("<form action=\"Login\" method=\"post\">");
		out.println("	<input name=\"username\" type=\"text\" placeholder=\"username\">");
		out.println("	<input name=\"password\" type=\"password\" placeholder=\"password\">");
		out.println("	<input type=\"submit\">");
		out.println("</form>");
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		if (username != null && username.equals("albert") && password != null && password.equals("abcd")) {
			
			// If the User authenticated, create a new User object with their info
			User user = new User("Albert", "Cervantes");
			
			// Get a reference to the session
			HttpSession session = request.getSession();
			
			// Add the user to the session
			session.setAttribute("user", user);
			
			// Redirect the User to the Members Only page
			response.sendRedirect("MembersOnly");		
			
		}
		
		request.setAttribute("error", true);
		
		doGet(request, response);
	}

}
