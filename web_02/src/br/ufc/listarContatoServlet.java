package br.ufc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/listarContatos")
public class listarContatoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, 
							HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
	
		ContatoDAO cDAO = new ContatoDAO();		
		List<Contato> contatos = new ArrayList<Contato>();
		contatos = cDAO.listar();
		
		request.setAttribute("contatos", contatos);
		request.getRequestDispatcher("listar_contatos_servlet.jsp").forward(request, response);
		
		
		/*
		PrintWriter writer = response.getWriter();	
		writer.write("<html><body>");
		for (Contato c : contatos) {
			writer.write(c.getNome() + "</br>");
		}
		writer.write("</body></html>");
		*/
		
		
	}
}
