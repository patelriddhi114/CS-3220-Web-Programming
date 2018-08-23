package Midterm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.GuestBookEntry;
import Models.User;
import solutions.notes.NoteUser;

@WebServlet("/Midterm/Inspireme")
public class Inspireme extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int pageCounter=0;
	int count=5;
	
	public Inspireme() {
        super();
        
	}
	public void init(ServletConfig config)throws ServletException
    {
    	super.init(config);
    	ArrayList<UserQuotes> quotes = new ArrayList<UserQuotes>();
    	
    	quotes.add(new UserQuotes("Introduction to Java Programming","Prentice Hall and Sun Microsystems Press"));
    	quotes.add(new UserQuotes("Computer Networks","jonn Martin"));
    	
    	getServletContext().setAttribute("quotes", quotes);
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		HttpSession session = request.getSession();
    	
    	response.setContentType("text/html");
		
		// Get a Print Writer
		PrintWriter out = response.getWriter();
		
		// Generate the template HTML
		out.println("<!DOCTYPE html>");		
		out.println("<html lang=\"en\">");
		out.println("<head>");
		out.println("    <meta charset=\"UTF-8\">");
		out.println("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
		out.println("        <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">");
		out.println("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">");
		out.println("        <title>Quotes Display</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		out.println("<a href=\"Admin\">Admin</a>");
		


    	ServletContext context= getServletContext();
    	
    	UserQuotes  previousQuote = (UserQuotes)session.getAttribute("previousQuote");
    	
    	ArrayList<UserQuotes> quotes = (ArrayList<UserQuotes>) context.getAttribute("quotes");
    	Random  rnd = new Random();
    	UserQuotes quote;
    	quote  = quotes.get(rnd.nextInt(quotes.size()));
    	
    	out.println("<h1 class=\"display-4\">" + quote.getText()+"</h1>");
    	out.println("<p class=\"lead text-right\">");
    	out.println("- " + quote.getAuthor());
    	out.println("<br>");
    	out.println("<a class=\"btn btn-primary\" href=\"Like?id="+quote.getId() + "\">Like</a>");
    	out.println("<a class=\"btn btn-primary\" href=\"Dislike?id="+quote.getId() + "\">Disike</a>");
    	
    	out.println("</p>");
    	out.println("</div>");
    	out.println("</body>");
    	out.println("</html>");
    	
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		doGet(request, response);
	}

}
