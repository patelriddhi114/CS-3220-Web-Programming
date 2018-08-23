package requests;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.GuestBookEntry;

@WebServlet("/requests/AddEntry")
public class AddEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub

			response.setContentType("text/html");		
			PrintWriter out = response.getWriter();
			
			out.println("<html>");
			out.println("<head>");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n" + "out.printlncrossorigin=\"anonymous\">");
				out.println("<title>");
			    	out.println("Add Entry");        
		        out.println("</title>");
	        out.println("</head>");
	        out.println("<body>");
	        out.println("<div class=\"container\">");
	        
	        	out.println("<form action=\"AddEntry\" method=\"post\">");
	        	
	        	if(request.getAttribute("nameError") != null)
	        	{
	        		out.println("<p class=\"text-danger\">" + request.getAttribute("nameError") + "</p>");
	        	}
	        	
	        	String name="";
	        	if(request.getParameter("name")!= null)
	        		name = request.getParameter("name");
	        	
	        	out.println("<input type=\"text\" name=\"name\" value=\"" +name+ "\" placeholder=\"Enter your name\">");
	        	out.println("<br>");
	        	
	        	if(request.getAttribute("messageError") != null)
	        	{
	        		out.println("<p class=\"text-danger\">" + request.getAttribute("messageError") + "</p>");
	        	}
	        	
	        	String message= request.getParameter("message");
	        	message = message == null? "" : message;
	        	
	        	
	        	out.println("<textarea name=\"message\">" +message+ "</textarea>");
	        	out.println("<br>");
	        	out.println("<input type=\"submit\" value=\"Add Entry\"/>");
	        	
	        out.println("</form>");
	        out.println("</div>");
	        out.println("</body>");
	        out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		boolean hasError=false;
		if(name == null || name.trim().length() ==0 )
		{
			request.setAttribute("nameError", "Invalid Name");
			hasError=true;
		}
		if(message == null || message.trim().length()==0)
		{
			request.setAttribute("messageError", "Invalid message");
			hasError=true;
		}
		if(hasError)
		{
			doGet(request,response);
		}
		else {	
		
			ArrayList<GuestBookEntry> entries= (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		
			entries.add(new GuestBookEntry(name,message));
		
			response.sendRedirect("GuestBook");
		}
				
				
		doGet(request, response);
	}

}
