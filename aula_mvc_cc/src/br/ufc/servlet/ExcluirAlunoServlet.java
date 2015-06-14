package br.ufc.servlet;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.dao.ContatoDAO;
import br.ufc.model.Contato;


import br.ufc.dao.AlunoDAO;
import br.ufc.model.Aluno;

public class ExcluirAlunoServlet implements ILogicaServlet{

	@Override
	public String executar(HttpServletRequest req,
			HttpServletResponse res){
		 
	Long id = Long.parseLong(req.getParameter("id"));
	Aluno a = new Aluno();
	a.setId(id);
	
	AlunoDAO aDAO = new AlunoDAO();
	aDAO.excluir(a);
	
	return "principal?classe=ListarAlunoServlet";
	}
}





