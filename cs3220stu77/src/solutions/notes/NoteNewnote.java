package solutions.notes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.GuestBookEntry;


@WebServlet("/solutions.notes/NoteNewnote")
public class NoteNewnote extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	NoteUser user = null;
    Note currentNote=null;
    

    public NoteNewnote() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (user == null) {
			response.sendRedirect("Login");
			return;
		}
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
		out.println("        <title>New Notes </title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		
		out.println("<form action=\"NoteNewnote\" method=\"post\">");
		
		
		//Note note = getEntry(request);
    	
		HttpSession session = request.getSession();
		
		// Get a reference to the name attribute (if it exists) from the SESSION scope
		String titleError = (String) session.getAttribute("titleError");
		String textError = (String) request.getAttribute("textError");


		
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String date = request.getParameter("created");
		
		
		
		if (title != null) {
			out.println("        <input class=\"form-control is-invalid\"  value=\"" + title + "\" type=\"text\" name=\"title\" id=\"title\" placeholder=\"Enter your title\">");
			out.println("        <div class=\"invalid-feedback\">" + titleError + "</div>");
		}  			
		else	
			out.println("        <input class=\"form-control\" type=\"text\" value=\"" + title + "\" name=\"title\" id=\"title\" placeholder=\"Enter your title\">");
		
		
		if (text != null) {
			out.println("        <input class=\"form-control is-invalid\"  value=\"" + text + "\" type=\"text\" name=\"text\" id=\"title\" placeholder=\"Enter your text\">");
			out.println("        <div class=\"invalid-feedback\">" + textError + "</div>");
		}  			
		else	
			out.println("        <input class=\"form-control\" type=\"text\" value=\"" + text + "\" name=\"text\" id=\"text\" placeholder=\"Enter your title\">");
		
		
		
		out.println("	<input type=\"submit\" value=\"Add Entry\">");
		out.println("</form>");
		
		
		
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
		int id = Integer.parseInt(request.getParameter("noteId"));
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		String date = request.getParameter("created");
				
		ServletContext context= getServletContext();
		ArrayList<Note> notes = (ArrayList<Note>)context.getAttribute("notes");
		
		
	//	title = (String) request.getSession().getAttribute("name");
		
		if (title == null)
			title = request.getParameter("title");
		


		
		if (title == null || title.trim().length() == 0 || text == null || text.trim().length() == 0) {
			doGet(request, response);
		}		
		else {		
			notes.add( new Note(id,title,text));
			// Add the name to the Session scope
			
			request.getSession().setAttribute("name", title);
			
			// Redirect the User back to the main guestbook page
			response.sendRedirect("GuestBook");
		}
		
	}

}
