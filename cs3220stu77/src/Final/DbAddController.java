package Final;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Connection;


@WebServlet("/Final/AddController")
public class DbAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	Connection c;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher( "/WEB-INF/Final/Organizer.jsp" ).forward(request, response );
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		//Course
		String cnumber = request.getParameter( "cnumber" );
		String cname = request.getParameter( "cname" );
		        
		boolean hasError=false;
        if(hasError)
        {
        	doGet(request, response);
        }
        else
        {    	
	        try
	        {
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu77";
	            String username = "cs3220stu77";
	            String password = "D!SAZPAB";
	            
	            c = (Connection) DriverManager.getConnection( url, username, password );

	            Statement pstmt = c.createStatement( );
	            
	            
	            String sql ="insert into course (cnumber,cname)values(\"" + cnumber + "\",\"" + cname + "\")";
	            //System.out.println("sql"+sql);
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
		}
        request.getRequestDispatcher("/WEB-INF/Final/Organizer.jsp").forward(request, response);
	}
}
