package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Final/DeleteCourse")
public class DbDeleteCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		int id = Integer.parseInt(request.getParameter("cid"));
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu77";
            String username = "cs3220stu77";
            String password = "D!SAZPAB";

            c = DriverManager.getConnection( url, username, password );
            String sql = "delete from course where cid = ?";
            
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setInt( 1, id );
            pstmt.executeUpdate();
            
            
            pstmt.close();
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
