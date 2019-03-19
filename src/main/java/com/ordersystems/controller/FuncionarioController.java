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

import com.ordersystems.domain.Funcionario;
import com.ordersystems.service.FuncionarioService;

@RestController
public class FuncionarioController {
	@Autowired
	FuncionarioService funcionarioService;
	
	@RequestMapping(method=RequestMethod.GET,value="/funcionario",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		return new ResponseEntity<>(funcionarioService.buscarTodos(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/funcionario",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adicionarProduto(@RequestBody Funcionario funcionario){
		funcionarioService.adicionar(funcionario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/funcionario",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> alterarProduto(@RequestBody Funcionario funcionario){
		funcionarioService.salvar(funcionario);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/funcionario/{id}")
	public ResponseEntity<?> removerProduto(@PathVariable Integer id){
		Funcionario funcionarioEncontrado = funcionarioService.buscarPorId(id).get();
		if(funcionarioEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			funcionarioService.remover(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
}
