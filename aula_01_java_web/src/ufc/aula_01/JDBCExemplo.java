package ufc.aula_01;

import java.util.Date;
import java.util.List;



public class JDBCExemplo {

	public static void main(String[] args){
		
		 /*Contato c = new Contato("Jefferson de Carvalho Silva", "R. do Cedro",
				 				   new Date(), "9999 5656");
		 c.setId(29L);
		 ContatoDAO cDAO = new ContatoDAO();
		 cDAO.atualizar(c);*/
		
		ContatoDAO cDAO = new ContatoDAO();
		List<Contato> contatos = cDAO.listar();
		for(Contato c:contatos){
			System.out.println(c);
		}
		
		/*Contato c = new Contato();
		c.setId(10L);
		ContatoDAO cDAO = new ContatoDAO();
		Contato cRef = cDAO.get(c);
		System.out.println(cRef);*/
		
	}
}
