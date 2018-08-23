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


@WebServlet("/Homework3/EditCustomer")
public class EditCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected CustomerEntry getEntry(int id)
	{
		ArrayList<CustomerEntry> entries = (ArrayList<CustomerEntry>) getServletContext().getAttribute("entries");
		for(CustomerEntry entry : entries)
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
		
			CustomerEntry entryToEdit = getEntry(id);
					
			if(entryToEdit != null)
			{
				request.setAttribute("entry", entryToEdit);
				request.getRequestDispatcher("/WEB-INF/Homework3/EditCustomer.jsp").forward(request, response);
				
			}
		}
		catch(Exception e)
		{
			response.sendRedirect("Main");
			return;
		}		
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try
		{
			int id = Integer.parseInt(request.getParameter("id"));
			CustomerEntry entry =getEntry(id);
			
			String name= request.getParameter("name");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String phone = request.getParameter("phone");
			String gender = request.getParameter("gender");
			String opportunity_name = request.getParameter("opportunity_name");
			String account = request.getParameter("account");
			
			entry.setName(name);
			entry.setAddress(address);
			entry.setEmail(email);
			entry.setPhone(phone);
			entry.setGender(gender);
			entry.setOpportunity_name(opportunity_name);
			entry.setAccount(account);
			
		}
		catch(Exception e)
		{
			
		}
		finally {
			response.sendRedirect("Main");
		}
	}

}
