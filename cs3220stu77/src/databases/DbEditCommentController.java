package databases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.GuestBookEntry;


@WebServlet("/databases/EditComment")
public class DbEditCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected GuestBookEntry getEntry(int id) throws ServletException
	{
		GuestBookEntry entry = null;
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu77";
            String username = "cs3220stu77";
            String password = "D!SAZPAB";

            String sql = "select * from guestbook where id = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setInt( 1, id );
            ResultSet rs = pstmt.executeQuery();

            if( rs.next() )
                entry = new GuestBookEntry( rs.getInt( "id" ),
                    rs.getString( "name" ), 
                    rs.getString( "message" ) );
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

        return entry;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			int id = Integer.parseInt(request.getParameter("id"));
		
			GuestBookEntry entryToEdit = getEntry(id);
					
			if(entryToEdit != null)
			{
				request.setAttribute("entry", entryToEdit);
				request.getRequestDispatcher("/WEB-INF/mvc/EditComment.jsp").forward(request, response);
				
			}
		}
		catch(Exception e)
		{
			response.sendRedirect("GuestBook");
			return;
		}		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		String name = request.getParameter( "name" );
        String message = request.getParameter( "message" );
        
        int id = Integer.parseInt(request.getParameter("id"));
		

	
        Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu77";
            String username = "cs3220stu77";
            String password = "D!SAZPAB";

            String sql = "update guestbook set name = ?, message = ? where id = ?";

            c = DriverManager.getConnection( url, username, password );
            PreparedStatement pstmt = c.prepareStatement( sql );
            pstmt.setString( 1, name );
            pstmt.setString( 2, message );
            pstmt.setInt( 3, id );
            pstmt.executeUpdate();
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

        // send the user back to the guest book page
        response.sendRedirect( "GuestBook" );

	}

}
