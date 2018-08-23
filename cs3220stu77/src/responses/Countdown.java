package responses;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/responses/Countdown")
public class Countdown extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Countdown() {
        super();
        // TODO Auto-generated constructor stub
    }
    int count =5;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		response.setContentType("text/html");
		
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n" + "crossorigin=\"anonymous\">");
			out.println("<title>");
		    	out.println("Countdown");        
	        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class-\"container\">");
        
        	
        if(count >0)
        {
        	out.println("<h1 class=\"display-4\">T-minus" + count +" second and counting...</h1>");
        	count--;
        	response.setIntHeader("Refresh", 1);
        }	
        else
        {
        	out.println("<h1 class=\"display-1\">Blast Off!!</h1>");
        	count=5;
        }
        
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
