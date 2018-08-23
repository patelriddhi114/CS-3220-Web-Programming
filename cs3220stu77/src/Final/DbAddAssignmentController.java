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


@WebServlet("/Final/AddAssignment")
public class DbAddAssignmentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int cid = Integer.parseInt(request.getParameter("cid"));
		String assiDesc = request.getParameter( "assiDesc" );
		
		assignment a= new assignment(cid, assiDesc);        
		boolean hasError=false;
        if(hasError)
        {
        	doGet(request, response);
        }
        else
        {
        	Connection c = null;
	        try
	        {
	        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu77";
	            String username = "cs3220stu77";
	            String password = "D!SAZPAB";
	            
	            c = (Connection) DriverManager.getConnection( url, username, password );

	            Statement pstmt = c.createStatement( );
	            
	            String sql ="insert into assignment (cid,assiDesc)values(\"" + cid + "\",\"" + assiDesc + "\")";
	            //System.out.println("sql"+sql);
	            pstmt.executeUpdate(sql);
	            request.getRequestDispatcher("/WEB-INF/Final/Organizer.jsp").forward(request, response);
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
	}

}
