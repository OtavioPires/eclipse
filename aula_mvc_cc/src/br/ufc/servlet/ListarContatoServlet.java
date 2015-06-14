package br.ufc.servlet;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.dao.ContatoDAO;
import br.ufc.model.Contato;

public class ListarContatoServlet implements ILogicaServlet{

	@Override
	public String executar(HttpServletRequest req,
			HttpServletResponse res){
		 
		ContatoDAO cDAO = new ContatoDAO();
		List<Contato> contatos = cDAO.getLista();
		req.setAttribute("contatos", contatos);
		req.setAttribute("tamanho", contatos.size());
		
		return "listar_contatos.jsp";
		
	}
}





