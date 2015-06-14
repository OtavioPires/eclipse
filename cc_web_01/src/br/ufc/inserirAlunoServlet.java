package br.ufc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/inserirAluno")
public class inserirAlunoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, 
							HttpServletResponse response)
			throws ServletException, IOException {
		
		String matricula = request.getParameter("matricula");
		String nome = request.getParameter("nome");
		String nascimento = request.getParameter("nascimento");
		String email = request.getParameter("email");
		
		Aluno aluno = new Aluno();
		
		aluno.setMatricula(matricula);
		aluno.setNome(nome);
		
		aluno.setNascimento(new Date(0));
		
		aluno.setEmail(email);
		
		AlunoDAO aDAO = new AlunoDAO();
		
		aDAO.inserir(aluno);
		
		PrintWriter writer = response.getWriter();
		writer.write("<html>"
				+ "<head>"
				+ "<title> Inserir aluno </title>"
				+ "</head>"
				+ "<body>"
				+ "<h1>" + aluno + "</h1>"
				+ "</body>"
				+ "</html>");

	}	
	
}
