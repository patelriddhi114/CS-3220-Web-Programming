package Labs;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.GuestBookEntry;

@WebServlet("/Labs/RequestSummary")
public class RequestSummary extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RequestSummary() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		
		response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
    	out.println("<html>");
		out.println("<head>");
		
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n" + "crossorigin=\"anonymous\">");
			out.println("<title>");
		    	out.println("RequestSummary");        
	        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class-\"container\">");
        
        
        
        	ServletContext context= getServletContext();
        	
        	//RequestSummaryEntry entry;
        
        	Date created = new Date();
        	
        	out.println("<h1>  <b>Request Parameters Lab3</b></h1>");
        	out.println("The following<code>" + request.getMethod()+ "</code> request submitted on " + created);
        	
        	
        	out.println("<h3><b>Request Parameters</b></h3>");
        	
        	out.println("<table class=\"table table-bordered table-striped table-hover\">");
        	
        
        	out.println("<tr>");
    		out.println("	<th> Paramter Name </th>");
    		out.println("	<th> Paramter Value </th>");
    		out.println("</tr>");
    		
    		Enumeration<String> parameterName = request.getParameterNames();
    		
    		while(parameterName.hasMoreElements())
    		{
    			String p_Name = parameterName.nextElement();
    			
    			out.println("				<tr>");
    			out.println("					<td>" + p_Name+ "</td>");
    			out.print("						<td>");
    			
    				for( String value : request.getParameterValues( p_Name ) )
    				{
    				 	out.print("<span class=\"label label-info\">" + value + "</span>");
    				}
    			out.println("					</td>");
    			out.println("				</tr>");
    		}
    		
        	out.println("</table>");

        	out.println("<h3><b>Header Information</b></h3>");
        	
        	out.println("<table class=\"table table-bordered table-striped table-hover\">");
        
        	out.println("<tr>");
    		out.println("	<th> Header Feild </th>");
    		out.println("	<th> Heaader Value </th>");
    		out.println("</tr>");
    		
        	
        	
        	Enumeration headerNames = request.getHeaderNames();
        	while(headerNames.hasMoreElements()) 
        	{
        			String headerName = (String)headerNames.nextElement();
        			out.println("<TR><TD>" + headerName);
        			out.println("  <TD>" + request.getHeader(headerName));
  		  	}
        
        	out.println("</table>");
        	out.println("</body>");
        	
        	out.println("</html>");
        	
        	
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
