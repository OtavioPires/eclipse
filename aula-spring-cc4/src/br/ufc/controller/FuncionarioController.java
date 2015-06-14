package br.ufc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.FuncionarioDAO;
import br.ufc.model.Funcionario;
 

@Controller
public class FuncionarioController {

	private FuncionarioDAO funcionarioDAO;
	
	@Autowired
	public FuncionarioController(FuncionarioDAO funcionarioDAO){
		this.funcionarioDAO = funcionarioDAO;
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session){
		if(session!=null)
			session.invalidate();
		return "../../index";
	}
	
	@RequestMapping("loginForm")
	public String loginForm(){
		return "login_form";
	}
	
	@RequestMapping("efetuarLogin")
	public String efetuarLogin(Funcionario f, HttpSession session){
		

		Funcionario funcBanco = this.funcionarioDAO.getFuncionarioByLogin(f);
		
		
		if( (funcBanco==null) 
				||
		!(funcBanco.getSenha().equals(f.getSenha())) )
			return "login_form";
		
		session.setAttribute("logado", funcBanco);
		
		return "login_efetuado";
	}
}
