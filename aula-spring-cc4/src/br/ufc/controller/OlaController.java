package br.ufc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class OlaController {
	
	@RequestMapping("olaSpring")
	public String execute() {
		System.out.println("Executando a lógica com Spring MVC");
		return "ok";
	}
}