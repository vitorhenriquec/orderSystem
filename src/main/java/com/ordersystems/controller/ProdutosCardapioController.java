package com.ordersystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystems.service.ProdutosCardapioService;

@RestController
public class ProdutosCardapioController {

	@Autowired
	ProdutosCardapioService produtosCardapioService;
	
	@RequestMapping(method=RequestMethod.GET,value="/produtosCardapio",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		return new ResponseEntity<>(produtosCardapioService.buscarTodos(),HttpStatus.OK);
	}
}
