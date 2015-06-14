package br.ufc.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufc.dao.ContatoDAO;
import br.ufc.model.Contato;

@Controller
public class ContatoController {

	private ContatoDAO contatoDAO;
	
	@Autowired
	public ContatoController(ContatoDAO contatoDAO){
		this.contatoDAO = contatoDAO;
	}
	
	@RequestMapping("formularioContato")
	public String formularioContato(){
		return "formulario_contato";
	}
	
	@RequestMapping("listarContato")
	public String listarContato(Model model){
		

		List<Contato> contatos = this.contatoDAO.getLista();
		model.addAttribute("contatos", contatos);
		model.addAttribute("qtd", contatos.size());
		
		return "listar_contato";
	}
	
	@RequestMapping("adicionarContato")
	public String adicionarContato(@Valid Contato contato,
									BindingResult result){
		
		if(result.hasErrors()){
			return "formulario_contato";
		}
			
		this.contatoDAO.inserir(contato);
	
		return "contato_adicionado";
	}
	
	@RequestMapping("excluirContato")
	public String excluir(Contato contato){
		
		this.contatoDAO.excluir(contato);

		return "redirect:listarContato";
	}
	
	
}


















