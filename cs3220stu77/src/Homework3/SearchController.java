package Homework3;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CustomerEntry;


@WebServlet("/Homework3/Search")
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected CustomerEntry getEntry(HttpServletRequest request) {

		String name = request.getParameter("search");

		ArrayList<CustomerEntry> entries = (ArrayList<CustomerEntry>) getServletContext().getAttribute("entries");

		for (CustomerEntry entry : entries)
			if (entry.getName().equalsIgnoreCase(name))
				return entry;
		return null;
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		out.println("        <title>Search Customer</title>");
		out.println("</head>");
		out.println("<body>");

		CustomerEntry entry = getEntry(request);

		if (entry == null) {
			out.println("<h1> No Customer <h1>");
		}

		else {
			out.println("<div>");
			// Display all entries in table
			out.println("<table border=\"1\" >");
			// for each entry, we want to display a new row in our table
			out.println("<tr>");
			out.println("<td>ID</td>");
			out.println("<td>Name</td>");
			out.println("<td>Address</td>");
			out.println("<td>Email</td>");
			out.println("<td>Phone</td>");
			out.println("<td>Gender</td>");
			out.println("<td>O_Name</td>");
			out.println("<td>Accoutn</td>");
			out.println("</tr>");
			out.println("<tr>");
			out.println("<td>" + entry.getName() + "</td>");
			out.println("<td>" + entry.getAddress() + "</td>");
			out.println("<td>" + entry.getEmail() + "</td>");
			out.println("<td>" + entry.getPhone() + "</td>");
			out.println("<td>" + entry.getGender() + "</td>");
			out.println("<td>" + entry.getOpportunity_name() + "</td>");
			out.println("<td>" + entry.getAccount() + "</td>");
			out.println("</tr>");

			out.println("</table>");
			out.println("</div>");
		}
		out.println("</body>");
		out.println("</html>");


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
