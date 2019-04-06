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

import com.ordersystems.domain.Mesa;
import com.ordersystems.service.MesaService;

@RestController
public class MesaController {
	
	@Autowired
	MesaService mesaService;
	
	@RequestMapping(method=RequestMethod.GET,value="/mesa",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		try {
			return new ResponseEntity<>(mesaService.buscarTodos(),HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/mesa",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adicionarProduto(@RequestBody Mesa mesa){
		try {
			mesaService.adicionar(mesa);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/mesa",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> alterarProduto(@RequestBody Mesa mesa){
		try {
			mesaService.salvar(mesa);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/mesa/{id}")
	public ResponseEntity<?> removerProduto(@PathVariable Integer id){

		try {
			mesaService.buscarPorId(id).get();
				try {
					mesaService.remover(id);
					return new ResponseEntity<>(HttpStatus.OK);
				}
				catch(Exception e) {
					return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
				}
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}

}
