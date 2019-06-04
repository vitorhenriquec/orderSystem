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
import com.ordersystems.domain.Bebida;
import com.ordersystems.exception.NegocioException;
import com.ordersystems.service.ProdutoService;

@Controller
@RestController
public class BebidaController implements ProdutoController{
	@Autowired
	ProdutoService produtoService;
	
	@Override
	@RequestMapping(method=RequestMethod.GET,value="/bebida",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarProdutos(){
		return new ResponseEntity<>(produtoService.buscarTodos(),HttpStatus.OK);
	}
	
	@Override
	@RequestMapping(method=RequestMethod.POST,value="/bebida",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public <T extends Produto> ResponseEntity<?> adicionarProduto(@RequestBody T produto) {
		Bebida bebida = (Bebida) produto;
		try {
			produtoService.adicionar(bebida);
		} catch (NegocioException e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@Override
	@RequestMapping(method=RequestMethod.DELETE,value="/bebida/{id}")
	public ResponseEntity<?> removerProduto(@PathVariable Integer id){
		Produto produtoEncontrado = produtoService.buscarPorId(id).get();
		if(produtoEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			produtoService.remover(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
}
