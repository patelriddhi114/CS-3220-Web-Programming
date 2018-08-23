package solutions.notes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Models.GuestBookEntry;


@WebServlet("/solutions.notes/NoteEdit")
public class NoteEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public NoteEdit() {
        super();
        // TODO Auto-generated constructor stub
    }
    NoteUser user = null;
    Note currentNote=null;
    protected Note getEntry(HttpServletRequest request)
    {
    	HttpSession session = request.getSession();
		
		// Get a reference to the NoteUser object stored in the session
		user = (NoteUser) session.getAttribute("user");
		
		// Get a reference to the notes array list
		ArrayList<Note> notes = (ArrayList<Note>) getServletContext().getAttribute("notes");
		
		// Get a reference to the current note (if applicable)
		Note currentNote = null;
		try {
			int noteId = Integer.parseInt(request.getParameter("noteId"));
			for(Note note : notes) {
				if (note.getId() == noteId) {
					currentNote = note;
					break;
				}
			}
		}catch(Exception e) {}
		return null;
		
    }
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if (user == null) {
			response.sendRedirect("Login");
			return;
		}
		
		// Set the content type to HTML
		
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
		out.println("        <title>Notes Edit</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div class=\"container\">");
		
		
		out.println("<form action=\"Edit\" method=\"post\">");
		
		
		Note note = getEntry(request);
    	if (note ==null)
    	{
    		response.sendRedirect("No note avaliable");
    		return;
    	}
    	
    	if (currentNote == null) {
			out.println("<p class=\"lead\">Please create or select a note to display.</p>");
		}else {
			out.println("		<div class=\"card\">");
			out.println("  			<div class=\"card-body\">");
			out.println("    			<h5 class=\"card-title\">" + currentNote.getTitle() + "</h5>");
			out.println("    			<h6 class=\"card-subtitle mb-2 text-muted\">" + currentNote.getCreated() + "</h6>");
			out.println("	 			<p class=\"card-text\">" + currentNote.getText() + "</p>");
			out.println("				<input type=\"submit\" value=\"Save\"/>");
			out.println("				<input type=\"submit\" value=\"Delete\"/>");
			out.println("  			</div>");
			out.println("		</div>");
		}
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String title = request.getParameter("title");
		String text = request.getParameter("text");
		
		
		Note  notes = getEntry(request);
		notes.setTitle(title);
		notes.setText(text);
	
		doGet(request, response);
	}

}
