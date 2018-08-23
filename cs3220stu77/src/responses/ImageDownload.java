package responses;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/responses/ImageDownload")
public class ImageDownload extends HttpServlet {
	private static final long serialVersionUID = 1L;
       


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("image/jpg");
		response.setHeader("Content-Disposition","attachment; filename==pinky_a.jpg");
		
		FileInputStream in = new FileInputStream("C:/RiddhiDocument/MS Computer Science/CS-3220 Web-Programming/pinky.jpg");
		OutputStream out = response.getOutputStream();
		
		
		byte buffer[] = new byte[2048];
		int byteRead;
		while((byteRead = in.read(buffer)) > 0)
			out.write(buffer,0,byteRead);
		
		in.close();
		

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
