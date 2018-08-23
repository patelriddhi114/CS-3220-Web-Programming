package requests;

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

import Models.GuestBookEntry;


@WebServlet("/requests/GuestBook")
public class GuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public void init(ServletConfig config)throws ServletException
    {
    	super.init(config);
    	ArrayList<GuestBookEntry> entries = new ArrayList<GuestBookEntry>(); 
    	
    	entries.add(new GuestBookEntry("John Doe","Hello,World!"));
    	entries.add(new GuestBookEntry("Joe Boxer","Hi"));
    	entries.add(new GuestBookEntry("Mary Jane","H0wdy"));
    	
    	getServletContext().setAttribute("entries", entries);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
    
    	response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
    	out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n" + "crossorigin=\"anonymous\">");
			out.println("<title>");
		    	out.println("Guest Book");        
	        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("hi...");
        out.println("<div class=\"container\">");
        
        	out.println("<h1>  Guest Book</h1>");
        	
        	ServletContext context= getServletContext();
        	
        	ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) context.getAttribute("entries");
        	
        	
        	
        	out.println("<table class=\"table table-bordered table-striped table-hover\">");
        	
        
        	
        	for(GuestBookEntry entry : entries)
        	{
        		out.println("<tr>");
        		out.println
        		("	<td>" + entry.getName() + "</td>");
        		out.println("	<td>" + entry.getMessage() + "</td>");
        		out.println("	<td>" + entry.getCreated() + "</td>");
        		out.println("	<td>" );
        			out.println("	<a class=\"btn btn-primary\" href=\"EditEntry?id=" + entry.getId() +"\"> Edit</a>");
        		out.println("</td>");
        		out.println("	<td>" );
    				out.println("	<a class=\"btn btn-primary\" href=\"DeleteEntry?id=" + entry.getId()+ "\"> Delete</a>");
    			out.println("</td>");
    		
        		
        		out.println("</tr>");
        		
        	}
        	out.println("</table>");
        	out.println("<a href=\"AddEntry\" class=\"btn btn-primary\">Add Entry</a>");
        	out.println("<a href=\"../cookies/AddWithCookies\" class=\"btn btn-primary\">AddWithCookies</a>");
        	out.println("<a href=\"../sessions/AddEntryWithSessions\" class=\"btn btn-primary\">AddWithSession</a>");
        	out.println("<a href=\"../Labs/DownloadGuestBook\" class=\"btn btn-primary\">Download GuestBook</a>");
        	
  
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
