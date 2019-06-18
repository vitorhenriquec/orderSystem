package com.ordersystems.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystems.domain.Bebida;
import com.ordersystems.domain.Comida;
import com.ordersystems.domain.Produto;
import com.ordersystems.exception.NegocioException;
import com.ordersystems.service.Service;

@Controller
@RestController
public class ProdutoController {
	private Service<Produto> service;
	
	@RequestMapping(method=RequestMethod.GET,value="/produto",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarProdutos(){
		List<Produto> produtos = new ArrayList<Produto>();
		if(service.buscarTodos() != null) {
			produtos = service.buscarTodos();
		}
		return new ResponseEntity<>(produtos,HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/bebida",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> adicionarProduto(@RequestBody Bebida produto) {
		try {
			service.adicionar(produto);
		} catch (NegocioException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/comida",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> adicionarComida(@RequestBody Comida produto) {
		try {
			service.adicionar(produto);
		} catch (NegocioException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
