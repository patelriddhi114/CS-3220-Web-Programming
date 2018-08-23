package Homework3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CustomerEntry;
import Models.GuestBookEntry;


@WebServlet("/Homework3/DeleteCustomer")
public class DeleteCustomer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<CustomerEntry> entries= (ArrayList<CustomerEntry>) getServletContext().getAttribute("entries");
		
		//int index = Integer.parseInt(request.getParameter("index"));
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		for(CustomerEntry entry : entries)
		{
			if(entry.getId() == id)
			{
				entries.remove(entry);
				break;
			}
		}
		response.sendRedirect("Main");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
