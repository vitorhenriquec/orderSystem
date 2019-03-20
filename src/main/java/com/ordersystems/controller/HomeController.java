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
	
	@RequestMapping("/cardapio")
	public String cardapio() {
		return "cardapio";
	}
	
	@RequestMapping("/pedido")
	public String pedido() {
		return "pedido";
	}
	
	@RequestMapping("/mesa")
	public String mesa() {
		return "produto";
	}
}
