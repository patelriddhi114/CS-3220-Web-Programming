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

@WebServlet("/requests/EditEntry")
public class EditEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public EditEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected GuestBookEntry getEntry(HttpServletRequest request)
    {
    	int id = Integer.parseInt(request.getParameter("id"));
    	
    	ArrayList<GuestBookEntry> entries= (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
    	
    	
    	for(GuestBookEntry entry : entries)
    		if(entry.getId() == id)
    			return entry;
    	return null;
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n" + "out.printlncrossorigin=\"anonymous\">");
			out.println("<title>");
		    	out.println("Edit Entry");        
	        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class-\"container\">");
        
        	out.println("<form action=\"EditEntry\" method=\"post\">");
        	
        	GuestBookEntry entry = getEntry(request);
        	if (entry ==null)
        	{
        		response.sendRedirect("GuestBook");
        		return;
        	}
        	
        	out.println("<input type=\"text\" name=\"name\" value=\"" +entry.getName()+ "\" placeholder=\"Enter your name\">");
        	out.println("<br>");
        	
        	out.println("<input type=\"hidden\" name=\"id\" value=\"" +entry.getId()+ "\" ><br>");
        	
        	out.println("<textarea name=\"message\">" +entry.getMessage()+ "</textarea>");
        	out.println("<br>");
        	out.println("<input type=\"submit\" value=\"Save Entry\"/>");
        	
        out.println("</form>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		
		String name = request.getParameter("name");
		String message = request.getParameter("message");
		
		
		GuestBookEntry  entry = getEntry(request);
		entry.setName(name);
		entry.setMessage(message);
		
		response.sendRedirect("GuestBook");
		
		
	}

}
