package com.ordersystems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystems.domain.Pedido;
import com.ordersystems.service.PedidoService;

@RestController
public class PedidoController {
	@Autowired
	PedidoService pedidoService;
	
	@RequestMapping(method=RequestMethod.GET,value="/pedido",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		return new ResponseEntity<>(pedidoService.buscarTodos(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/pedido",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adicionarProduto(@RequestBody Pedido pedido){
		pedidoService.adicionar(pedido);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/pedido",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> alterarProduto(@RequestBody Pedido pedido){
		pedidoService.salvar(pedido);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/pedido/{id}")
	public ResponseEntity<?> removerProduto(@PathVariable Integer id){
		Pedido pedidoEncontrado = pedidoService.buscarPorId(id).get();
		if(pedidoEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			pedidoService.remover(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
}