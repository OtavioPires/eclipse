package br.ufc.servlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface ILogicaServlet {

	public String executar(HttpServletRequest req, HttpServletResponse res);
}
