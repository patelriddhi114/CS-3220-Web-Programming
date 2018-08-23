package Homework3;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.CustomerEntry;


@WebServlet("/Homework3/Main")
public class MainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public void init(ServletConfig config) throws ServletException 
	{
		super.init(config);
		
		ArrayList<CustomerEntry> entries = new ArrayList<CustomerEntry>();
		entries.add(new CustomerEntry(1,"John","2342 Bok St","john@boxeer.com","7148953215","Male","SI Expansion","Beaar Paw"));
		entries.add(new CustomerEntry(2,"Joe","4383 Le Road","Joe@hou.com","254677882","Male","LSK Req","Sunlight Intelligence"));
		entries.add(new CustomerEntry(3,"Mary","2340 Walk St","mary@mi.com","6584564875","Female","EYS renewal","Paylays Cashways"));
		
		getServletContext().setAttribute("entries", entries);
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RequestDispatcher dispature = request.getRequestDispatcher("/WEB-INF/Homework3/Main.jsp");
		
		dispature.forward(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
