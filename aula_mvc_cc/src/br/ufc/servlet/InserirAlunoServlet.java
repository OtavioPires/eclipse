package br.ufc.servlet;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.dao.AlunoDAO;
import br.ufc.model.Aluno;


public class InserirAlunoServlet implements ILogicaServlet{
	
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response){
		
		
		String nome = request.getParameter("nome");
		String matricula = request.getParameter("matricula");
		String email = request.getParameter("email");
		String nascimento = request.getParameter("dataNascimento");
		
		Aluno aluno = new Aluno();
		aluno.setNome(nome);
		aluno.setMatricula(matricula);
		aluno.setEmail(email);
		aluno.setNascimento(new Date());
		
		AlunoDAO aDAO = new AlunoDAO();
		aDAO.inserir(aluno);
		
		return "aluno_adicionado.jsp";
	}

}