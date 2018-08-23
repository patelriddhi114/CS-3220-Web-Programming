package requests;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.GuestBookEntry;

@WebServlet("/requests/DeleteEntry")
public class DeleteEntry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteEntry() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ArrayList<GuestBookEntry> entries= (ArrayList<GuestBookEntry>) getServletContext().getAttribute("entries");
		
		//int index = Integer.parseInt(request.getParameter("index"));
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		for(GuestBookEntry entry : entries)
		{
			if(entry.getId() == id)
			{
				entries.remove(entry);
				break;
			}
		}
		response.sendRedirect("GuestBook");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
