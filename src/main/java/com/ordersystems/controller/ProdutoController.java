package com.ordersystems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystems.domain.Produto;
import com.ordersystems.service.ProdutoService;

@RestController
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;
	
	@RequestMapping(method=RequestMethod.GET,value="/produto",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		return new ResponseEntity<>(produtoService.findAll(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/produto",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> buscarTodos(@RequestBody Produto produto){
		produtoService.add(produto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
}
