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

@WebServlet("/listarAlunos")
public class listarAlunoServlet extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, 
							HttpServletResponse response)
			throws ServletException, IOException {
		
		String nome = request.getParameter("nome");
	
		AlunoDAO aDAO = new AlunoDAO();		
		List<Aluno> alunos = new ArrayList<Aluno>();
		alunos = aDAO.listar();
		
		PrintWriter writer = response.getWriter();
		writer.write("<html>" 
				+ "<head>"
				+ "<title> Listar alunos </title>"
				+ "</head>"
				+ "<body>"
				+ "<h1 style='text-align:center'>Lista de alunos</h1>"
				+ "<table border='2' style='width:100%'>");
				
				for (Aluno aluno : alunos) {
					writer.write("<tr>"
							+ "<td>" + aluno.getId() + "</td>"
							+ "<td>" + aluno.getMatricula() + "</td>"
							+ "<td>" + aluno.getNome() + "</td>"
							+ "<td>" + aluno.getNascimento() + "</td>"
							+ "<td>" + aluno.getEmail() + "</td>"
							+ "</tr>");
					
				}
				
				writer.write("</table>"
						+ "</body>"
				+ "</html>");
	}
}
