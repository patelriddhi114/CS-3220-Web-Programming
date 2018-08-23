package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.GuestBookEntry;

@WebServlet("/mvc/EditComment")
public class EditCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected GuestBookEntry getEntry(int id)
	{
		ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		for(GuestBookEntry entry : entries)
		{
			if(entry.getId() == id)
			{
				return entry;
			}
		}
		return null;
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
		
		try
		{
			int id = Integer.parseInt(request.getParameter("id"));
			GuestBookEntry entry =getEntry(id);
			
			String name= request.getParameter("name");
			String message = request.getParameter("message");
			
			entry.setName(name);
			entry.setMessage(message);
		}
		catch(Exception e)
		{
			
		}
		finally {
			response.sendRedirect("GuestBook");
		} 
	}

}
