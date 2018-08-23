package requests;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/requests/add")
public class AdditionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public AdditionServlet() {
        super();
	}
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

        String operand1 = request.getParameter("op1");
        String operand2 = request.getParameter("op2");
		
        int sum=0;
        String error = null;
        try
        {
        	sum = Integer.parseInt(operand1)+Integer.parseInt(operand2);
        
        }
        catch(Exception e)
        {
        	response.sendRedirect("AdditionFrom.html");
        	return;
        	//error = "Invlid operands!!";
        }
       
        response.setContentType("text/html");
        
        PrintWriter out = response.getWriter();
        
        out.println("<html>");
		out.println("<head>");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\"\r\n" + "out.printlncrossorigin=\"anonymous\">");
			out.println("<title>");
		    	out.println("Addition Form");        
	        out.println("</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class-\"container\">");
        
        	out.println("<h1> Addition Servlet</h1>");
        	out.println("<p class=\"lead\">");
        	out.println("Sum of  "+ operand1 +" and " + operand2 + " = " + sum);
        	out.println("</p>");
        
        	out.println("<a href=\"AdditionForm.html\">");
        	out.println("Add more number");
        	out.println("</a>");
        	
        out.println("</div>");
        out.println("</body>");
        out.println("</html>"); 
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
