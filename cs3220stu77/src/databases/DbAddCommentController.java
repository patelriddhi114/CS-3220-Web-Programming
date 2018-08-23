package databases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.GuestBookEntry;


@WebServlet("/databases/AddComment")
public class DbAddCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		 request.getRequestDispatcher( "/WEB-INF/mvc/AddComment.jsp" ).forward(request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		 	String name = request.getParameter( "name" );
	        String message = request.getParameter( "message" );

	        
	        boolean hasError=false;
			if(name == null || name.trim().length()==0)
			{
				hasError = true;
				request.setAttribute("nameError", "Please enter a name");
			}
			if(message == null || message.trim().length()==0)
			{
				hasError = true;
				request.setAttribute("messageError", "Please enter a message ");
			}
			
			if(hasError)
			{
				doGet(request,response);
			}
			else
			{
				Connection c = null;
		        try
		        {
		        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu77";
		            String username = "cs3220stu77";
		            String password = "D!SAZPAB";

		            
		            c = DriverManager.getConnection( url, username, password );

		            Statement pstmt = c.createStatement( );
		            
		            
		            String sql ="insert into guestbook (name,message)values(\"" + name + "\",\"" + message + "\")";
		            System.out.println("sql"+sql);
		            pstmt.executeUpdate(sql);
		        }
		        catch( SQLException e )
		        {
		            throw new ServletException( e );
		        }
		        finally
		        {
		            try
		            {
		                if( c != null ) c.close();
		            }
		            catch( SQLException e )
		            {
		                throw new ServletException( e );
		            }
		        }
		        response.sendRedirect("GuestBook");
			}
			
	        
	}

}
