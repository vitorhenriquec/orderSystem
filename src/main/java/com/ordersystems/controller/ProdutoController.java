package com.ordersystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ordersystems.domain.Produto;
import com.ordersystems.domain.Tijolos;
import com.ordersystems.domain.Tintas;
import com.ordersystems.exception.NegocioException;
import com.ordersystems.service.ProdutoService;

@Controller
@RestController
public class ProdutoController {
	@Autowired
	ProdutoService produtoService;
	
	@RequestMapping(method=RequestMethod.GET,value="/produto",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		return new ResponseEntity<>(produtoService.buscarTodos(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/tintas",consumes = MediaType.APPLICATION_JSON_VALUE)
	public <T extends Produto>ResponseEntity<?> adicionarTintas(@RequestBody Tintas produto) {
		try {
			produtoService.adicionar(produto);
		} catch (NegocioException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/tijolos",consumes = MediaType.APPLICATION_JSON_VALUE)
	public <T extends Produto>ResponseEntity<?> adicionarComida(@RequestBody Tijolos produto) {
		try {
			produtoService.adicionar(produto);
		} catch (NegocioException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
