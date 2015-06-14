package br.ufc.interceptador;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptador extends HandlerInterceptorAdapter{

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		
		
		String uri = request.getRequestURI();
		if(uri.endsWith("loginForm") ||
		    uri.endsWith("efetuarLogin"))
			return true;
		
		HttpSession session = request.getSession();
		if(session.getAttribute("logado")!=null){
			return true;
		}
		
		response.sendRedirect("loginForm");
		return false;
		
	}
}
