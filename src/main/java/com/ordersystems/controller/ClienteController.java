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

import com.ordersystems.domain.Cliente;
import com.ordersystems.service.ClienteService;


@RestController
public class ClienteController {
	@Autowired
	ClienteService clienteService;
	
	@RequestMapping(method=RequestMethod.GET,value="/cliente",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		return new ResponseEntity<>(clienteService.buscarTodos(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cliente",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adicionarProduto(@RequestBody Cliente cliente){
		clienteService.adicionar(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/cliente",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> alterarProduto(@RequestBody Cliente cliente){
		clienteService.salvar(cliente);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/cliente/{id}")
	public ResponseEntity<?> removerProduto(@PathVariable Integer id){
		Cliente clienteEncontrado = clienteService.buscarPorId(id).get();
		if(clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			clienteService.remover(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
}
