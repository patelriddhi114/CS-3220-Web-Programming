package Labs;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Models.GuestBookEntry;

@WebServlet("/Labs/DownloadGuestBook")
public class DownloadGuestBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DownloadGuestBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		
		response.setContentType("application/vnd.ms-excel");
		response.setHeader("Content-Disposition","attachment; filename=DownloadGuestBook.xls");
		
		
		PrintWriter out = response.getWriter();
		ServletContext context = getServletContext();
		
		
		ArrayList<GuestBookEntry> entries = (ArrayList<GuestBookEntry>) context.getAttribute("entries");
    	
    	
    	
    	out.println("Name \t Message \t date");
    	
    
    	
    	for(GuestBookEntry entry : entries)
    	{
    		out.println(entry.getName() + "\t" + entry.getMessage() + "\t" + entry.getCreated());
    	}
				
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
