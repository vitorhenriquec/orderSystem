package com.ordersystems.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("/produto")
	public String produto() {
		return "produto";
	}
	
	@RequestMapping("/funcionario")
	public String funcionario() {
		return "funcionario";
	}
	
	
	@RequestMapping("/restaurante")
	public String restaurante() {
		return "restaurante";
	}
	
	@RequestMapping("/cardapio")
	public String cardapio() {
		return "cardapio";
	}
	
	@RequestMapping("/lista_cardapio")
	public String visualizarCardapio() {
		return "lista_cardapio";
	}
	
	@RequestMapping("/pedido")
	public String pedido() {
		return "pedido";
	}
	
	@RequestMapping("/mesa")
	public String mesa() {
		return "mesa";
	}
	
}
