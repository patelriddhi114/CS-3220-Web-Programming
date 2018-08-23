package Final;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/Final/Organizer")
public class DbOrganizer extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection c = null;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new ServletException(e);
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		ArrayList<CourseEntry> centry = new ArrayList<>();
		ArrayList<assignment> aentry = new ArrayList<>();

		try {
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu77";
			String username = "cs3220stu77";
			String password = "D!SAZPAB";

			c = (Connection) DriverManager.getConnection(url, username, password);
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery("select * from course");

			while (rs.next()) {
				CourseEntry c = new CourseEntry(rs.getInt(1), rs.getString(2), rs.getString(3));
				centry.add(c);
			}
			request.setAttribute("centry", centry);
			
			stmt = c.createStatement();
			rs = stmt.executeQuery("select * from assignment");
			while (rs.next()) {
				assignment a = new assignment(rs.getInt(1), rs.getInt(2), rs.getString(3));
				aentry.add(a);
			}
			request.setAttribute("aentry", aentry);
		} catch (SQLException e) {
			throw new ServletException(e);
		} finally {
			try {
				if (c != null)
					c.close();
			} catch (SQLException e) {
				throw new ServletException(e);
			}
		}

	request.getRequestDispatcher("/WEB-INF/Final/Organizer.jsp").forward(request,response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}
