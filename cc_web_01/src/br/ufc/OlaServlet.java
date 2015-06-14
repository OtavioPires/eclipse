package br.ufc;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ola_sem_xml")
public class OlaServlet extends HttpServlet{
	
	@Override
	protected void service( HttpServletRequest request, 
							HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter writer = response.getWriter();
		writer.write("<html>"
				+ "<head>"
				+ "<title>Home Page</title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>Mo paia</h1>"
				+ "</body>"
				+ "</html>");
		
	}

}
