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

import com.ordersystems.domain.Restaurante;
import com.ordersystems.service.RestauranteService;

@RestController
public class RestauranteController {
	@Autowired
	RestauranteService restauranteService;
	
	@RequestMapping(method=RequestMethod.GET,value="/restaurante",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		return new ResponseEntity<>(restauranteService.buscarTodos(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/restaurante",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adicionarProduto(@RequestBody Restaurante restaurante){
		restauranteService.adicionar(restaurante);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/restaurante",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> alterarProduto(@RequestBody Restaurante restaurante){
		restauranteService.salvar(restaurante);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/restaurante/{id}")
	public ResponseEntity<?> removerProduto(@PathVariable Integer id){
		Restaurante restauranteEncontrado = restauranteService.buscarPorId(id).get();
		if(restauranteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			restauranteService.remover(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
}
