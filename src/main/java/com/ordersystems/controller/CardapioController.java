package com.ordersystems.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystems.domain.Cardapio;
import com.ordersystems.domain.Produto;
import com.ordersystems.domain.Restaurante;
import com.ordersystems.exception.NegocioException;
import com.ordersystems.service.CardapioService;
import com.ordersystems.service.ProdutoService;
import com.ordersystems.service.RestauranteService;

@RestController
public class CardapioController {
	
	@Autowired
	CardapioService cardapioService;
	
	@Autowired
	ProdutoService produtosService;
	
	@Autowired
	RestauranteService restauranteService;
	
	
	@RequestMapping(method=RequestMethod.GET,value="/cardapio",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		return new ResponseEntity<>(cardapioService.buscarTodos(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/cardapio/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarUm(@PathVariable int id){
		try {
			Cardapio cardapio = cardapioService.buscarPorId(id).get();
			
			ResponseEntity<Cardapio> response = new ResponseEntity<>(cardapio, HttpStatus.OK);
			
			return response;
		} catch (Exception e) {
			return new ResponseEntity<Exception>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/cardapio", params="ativo", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarAtivo(@RequestParam("ativo") boolean ativo){
		return new ResponseEntity<>(cardapioService.buscarAtivo(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cardapio",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adicionarCardapio(@RequestBody Cardapio cardapio){
		try{
			Restaurante restaurante = restauranteService.buscarTodos().get(0);
			List<Produto> produtos = new ArrayList<>();
			
			for(Produto produto : cardapio.getProdutos()) {
				Produto produtoDB = produtosService.buscarPorId(produto.getId()).get();
				
				produtoDB.getCardapios().add(cardapio);
				
				produtos.add(produtoDB);
			}
			
			cardapio.setRestaurante(restaurante);
			cardapio.setProdutos(produtos);
			
			cardapioService.adicionar(cardapio);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/cardapio",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> alterarCardapio(@RequestBody Cardapio cardapio){
		try{
			Restaurante restaurante = restauranteService.buscarTodos().get(0);
			List<Produto> produtos = new ArrayList<>();
			
			for(Produto produto : cardapio.getProdutos()) {
				Produto produtoDB = produtosService.buscarPorId(produto.getId()).get();
				
				produtoDB.getCardapios().add(cardapio);
				
				produtos.add(produtoDB);
			}
			
			cardapio.setRestaurante(restaurante);
			cardapio.setProdutos(produtos);
			
			cardapioService.alterar(cardapio);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/cardapio/{id}")
	public ResponseEntity<?> removerCardapio(@PathVariable Integer id) {
		try {
			Cardapio cardapioEncontrado = cardapioService.buscarPorId(id).get();
			
			if(cardapioEncontrado != null) {
				cardapioService.remover(id);
				return new ResponseEntity<>(HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Object>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}