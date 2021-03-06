package databases;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Query")
public class SqlQueryController extends HttpServlet {
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
		// TODO Auto-generated method stu
		
		PrintWriter out = response.getWriter();
        out.print( "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0" );
        out.print( "Transitional//EN\">\n" );
        out.print( "<html><head><title>Hello JDBC</title></head>\n<body>" );

        
        out.println("<form action=\"Query\" method=\"get\">");
        out.println("<textarea name=\"sql\" plac eholder=\"Enter the query\"></textarea>");
        out.println("</br><input type=\"submit\" name=\"Submit\" value=\"Execute SQL\">");
        out.println("</form>");
        
        String sql = request.getParameter("sql");
        if(sql != null && sql.trim().length()>0)
        {
        
		        Connection c = null;
		        try
		        {
		        	String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu77";
		            String username = "cs3220stu77";
		            String password = "D!SAZPAB";
		
		            c = DriverManager.getConnection( url, username, password );
		            Statement stmt = c.createStatement();
		            ResultSet rs = stmt.executeQuery( sql);
		
		            ResultSetMetaData meta= rs.getMetaData();
		            int numberOfColumn = meta.getColumnCount();
		            
		            
		            out.println("<table>");
		            out.println("<tr>");
		            for(int i =1;  i<= numberOfColumn;i++)
		            {
		            	String columnName = meta.getColumnName(i);
		            	out.println("<td>"+ columnName+"</td>");
		            }
		            out.println("</tr>");
		            
		            while( rs.next() )
		            {
		            	out.println("<tr>");
		            	for(int i=1;i<=numberOfColumn;i++)
		            	{
		            		String columnName = rs.getString(i);
		            		out.println("<td>"+columnName+"</td>");
		            	}
		            	out.println("</tr>");
		            }
		            out.println("</table>");
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
		
		        out.print( "</body></html>" );
        }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
