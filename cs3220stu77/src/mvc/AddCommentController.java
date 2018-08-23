package mvc;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.GuestBookEntry;


@WebServlet("/mvc/AddComment")
public class AddCommentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		request.getRequestDispatcher("/WEB-INF/mvc/AddComment.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name= request.getParameter("name");
		String message = request.getParameter("message");
		
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
		if(!hasError)
		{
			ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>)getServletContext().getAttribute("entries");
			entries.add(new GuestBookEntry(name,message));
			response.sendRedirect("GuestBook");
		}
		else
		{
			doGet(request,response);
		}
	}

}
