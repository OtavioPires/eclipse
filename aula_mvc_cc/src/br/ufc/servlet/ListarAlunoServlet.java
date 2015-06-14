package br.ufc.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.dao.AlunoDAO;
import br.ufc.model.Aluno;

public class ListarAlunoServlet implements ILogicaServlet{

	@Override
	public String executar(HttpServletRequest req,
			HttpServletResponse res){
		 
		AlunoDAO aDAO = new AlunoDAO();
		List<Aluno> alunos = aDAO.getLista();
		req.setAttribute("alunos", alunos);
		req.setAttribute("tamanho", alunos.size());
		
		return "listar_alunos.jsp";
		
	}
}





