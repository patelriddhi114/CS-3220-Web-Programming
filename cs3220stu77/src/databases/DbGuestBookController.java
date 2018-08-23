package databases;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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


@WebServlet("/databases/GuestBook")
public class DbGuestBookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void init( ServletConfig config ) throws ServletException
    { 
        super.init( config );

        try
        {
            Class.forName( "com.mysql.jdbc.Driver" );
        }
        catch( ClassNotFoundException e )
        {
            throw new ServletException( e );
        }
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		Connection c = null;
        try
        {
        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu77";
            String username = "cs3220stu77";
            String password = "D!SAZPAB";

            c = DriverManager.getConnection( url, username, password );
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery( "select * from guestbook");

            ArrayList<GuestBookEntry> entries= new ArrayList<GuestBookEntry>();
            
            
            while( rs.next() )
            {
            	int id = rs.getInt("id");
            	String name = rs.getString("name");
            	String message = rs.getString("message");
            
            	entries.add(new GuestBookEntry(id, name, message));
            	
            }
            
            request.setAttribute("entries", entries);
            
            request.getRequestDispatcher("/WEB-INF/mvc/GuestBook.jsp").forward(request, response);
            
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
