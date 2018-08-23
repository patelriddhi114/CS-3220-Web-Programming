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


@WebServlet("/Homework3/AddCustomer")
public class AddCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/Homework3/AddCustomer.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name= request.getParameter("name");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String opportunity_name = request.getParameter("opportunity_name");
		String account = request.getParameter("account");
		
		boolean hasError=false;
		if(name == null || name.trim().length()==0)
		{
			hasError = true;
			request.setAttribute("nameError", "Please enter a name");
		}
		if(address == null || address.trim().length()==0)
		{
			hasError = true;
			request.setAttribute("addressError", "Please enter a address");
		}
		if(email == null || email.trim().length()==0)
		{
			hasError=true;
			request.setAttribute("emailError", "Please enter a email");
		}
		if(phone == null || phone.trim().length()==0)
		{
			hasError = true;
			request.setAttribute("phoneError", "Please enter a phone number ");
		}
		if(gender == null || gender.trim().length()==0)
		{
			hasError = true;
			request.setAttribute("genderError", "Please enter a gender ");
		}
		if(opportunity_name == null || opportunity_name.trim().length()==0)
		{
			hasError = true;
			request.setAttribute("oppo_nameError", "Please enter opportunity name  ");
		}
		if(account == null || account.trim().length()==0)
		{
			hasError = true;
			request.setAttribute("accountError", "Please enter account");
		}
		
		
		if(!hasError)
		{
			ArrayList<CustomerEntry> entries = (ArrayList<CustomerEntry>)getServletContext().getAttribute("entries");
			entries.add(new CustomerEntry(name,address,email,phone,gender,opportunity_name,account));
			response.sendRedirect("Main");
		}
		else
		{
			doGet(request,response);
		}
		
		
	}

}
