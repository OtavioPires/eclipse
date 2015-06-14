package br.ufc.servlet;


import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.ufc.dao.ContatoDAO;
import br.ufc.model.Contato;


public class InserirContatoServlet implements ILogicaServlet{
	
	@Override
	public String executar(HttpServletRequest request,
			HttpServletResponse response){
		
		
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
		
		return "contato_adicionado.jsp";
	}

}
