package br.ufc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/principal")
public class PrincipalServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		
		String nomeClasse = req.getParameter("classe");
		nomeClasse = "br.ufc.servlet."+nomeClasse;
		
		try {
			Class<?> classe = Class.forName(nomeClasse);
			ILogicaServlet logica = (ILogicaServlet)classe.newInstance();
			String pagina = logica.executar(req, res);
			RequestDispatcher rd = req.getRequestDispatcher(pagina);
			rd.forward(req, res);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 
	}

}
