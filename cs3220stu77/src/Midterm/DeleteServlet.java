package Midterm;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/Midterm/Delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			ArrayList<UserQuotes> deleteuquotes= (ArrayList<UserQuotes>) getServletContext().getAttribute("quotes");
			
			int id = Integer.parseInt(request.getParameter("id"));
			
			for(UserQuotes quote : deleteuquotes)
			{
				if(quote.getId() == id)
				{
					deleteuquotes.remove(quote);
					break;
				}
			}
			
		}catch(Exception e)
		{
			
		}
		finally {
			response.sendRedirect("Admin");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
