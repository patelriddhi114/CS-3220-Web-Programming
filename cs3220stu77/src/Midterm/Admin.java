package Midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.GuestBookEntry;
import midterminterview.MathQuestion;
import midterminterview.Quiz;
import solutions.notes.Note;
import solutions.notes.NoteUser;

@WebServlet("/Midterm/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
         
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method s
		
    	
		response.setContentType("text/html");
		
		// Get a Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate the template HTML
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n" + "crossorigin=\"anonymous\">");
			out.println("<title>");
		    	out.println("Renking Quotation");        
	        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class-\"container\">");
        
		
		out.println("<a href=\"Inspireme\" >Inspire Me</a>");
		
		
		out.println("<form class=\"form-inline\" action=\"Admin\" method=\"post\">");
			out.println("<input class=\"form-control\" type=\"text\" name=\"text\"  placeholder=\"Enter your quote\">");
			out.println("<input class=\"form-control\" type=\"text\" name=\"author\" placeholder=\"Enter your name\">");
			out.println("<input type=\"submit\" class=\"\btn btn-primary\" value=\"Add New Quotes\"/>");
		out.println("</form>");
		out.println("</div>");
		out.println("<div class=\"container vertical-center\">");
		
		ServletContext context = getServletContext();
		ArrayList<UserQuotes> quotes = (ArrayList<UserQuotes>)context.getAttribute("quotes");
		
		
		out.println("<table class=\"table table-bordered table-striped table-hover\">");
		
		out.println("<th>");
		//out.println("<td>  </td>");
		out.println("<td><b>Quote</b></td>");
		out.println("<td><b>Name</b></td>");
		out.println("<td><b>Viewed</b></td>");
		out.println("<td><b>Likes</b></td>");
		out.println("<td><b>DiLikes</b></td>");
		out.println("</th>");
		for(UserQuotes quote : quotes)
		{
			out.println("<tr>");
			out.println("<td>");
				out.println("<a class=\"btn btn-primary\" href=\"Delete?id="+ quote.getId() + "\">[X]</a>");
			out.println("</td>");
			out.println(" <td>" + quote.getText()+ "</td>");
			out.println(" <td>" + quote.getAuthor()+ "</td>");
			out.println(" <td>" + quote.getViewed() + "</td>");		
			out.println(" <td>" + quote.getLiked() + "</td>");
			out.println(" <td>" + quote.getDisliked()+"</td>");
			out.println("</tr>");
		}
		
		out.println("</table>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String text = request.getParameter("text");
		String author = request.getParameter("author");
		
		ArrayList<UserQuotes> quotes= (ArrayList<UserQuotes>) getServletContext().getAttribute("quotes");
		
		quotes.add(new UserQuotes(text,author));
		doGet(request,response);
		
	}
}