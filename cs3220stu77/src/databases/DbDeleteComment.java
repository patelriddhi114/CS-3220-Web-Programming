package databases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.GuestBookEntry;


@WebServlet("/databases/DeleteComment")
public class DbDeleteComment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	GuestBookEntry entry;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		int id = Integer.parseInt(request.getParameter("id"));
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu77";
            String username = "cs3220stu77";
            String password = "D!SAZPAB";

            String sql = "delete from guestbook where id = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setInt( 1, id );
            pstmt.executeUpdate();
            
            request.getRequestDispatcher("/WEB-INF/mvc/GuestBook.jsp").forward(request, response);
            pstmt.close();



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


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
