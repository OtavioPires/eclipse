package br.ufc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/inserirContato")
public class InserirContatoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		String nome = request.getParameter("nome");
		String celular = request.getParameter("celular");
		String endereco = request.getParameter("endereco");
		String nascimento = request.getParameter("dataNascimento");
		
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setCelular(celular);
		contato.setEndereco(endereco);
		contato.setNascimento(new Date());
		
		ContatoDAO cDAO = new ContatoDAO();
		cDAO.inserir(contato);
		
		PrintWriter out = response.getWriter();
		out.write("<html>");
		out.write("<body>");
		out.write("<h3>Contato inserido!</h3>");
		out.write("</body>");
		out.write("</html>");
		
	}

}
