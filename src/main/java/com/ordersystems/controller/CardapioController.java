package com.ordersystems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystems.domain.Cardapio;
import com.ordersystems.service.CardapioService;
import com.ordersystems.service.ProdutoService;

@RestController
public class CardapioController {
	
	@Autowired
	CardapioService cardapioService;
	
	@Autowired
	ProdutoService produtosService;
	
	
	@RequestMapping(method=RequestMethod.GET,value="/cardapio",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		return new ResponseEntity<>(cardapioService.buscarTodos(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/cardapio",consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> adicionarCardapio(@RequestBody Cardapio cardapio){
		try{
			cardapioService.adicionar(cardapio);
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		/*Cardapio newCardapio = new Cardapio();
		newCardapio.setNome(cardapioDTO.getCardapio().getNome());
		
		cardapioService.adicionar(newCardapio);
		
		for(int i = 0; i < cardapioDTO.getProdutos().size(); i++) {
			ProdutosCardapio pc = new ProdutosCardapio();
			pc.setCardapio(newCardapio);
			pc.setProduto(cardapioDTO.getProdutos().get(i));
			
			produtosCardapioService.adicionar(pc);
		}
		*/
	}
	
	/*@RequestMapping(method=RequestMethod.PUT,value="/cardapio",produces = MediaType.APPLICATION_JSON_VALUE,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
	public ResponseEntity<?> alterarCardapio(@RequestBody CardapioDTO cardapioDTO){
		
		Cardapio newCardapio = new Cardapio();
		newCardapio.setNome(cardapioDTO.getCardapio().getNome());
		
		cardapioService.alterar(newCardapio);
		
		for(int i = 0; i < cardapioDTO.getProdutos().size(); i++) {
			ProdutosCardapio pc = new ProdutosCardapio();
			pc.setCardapio(newCardapio);
			pc.setProduto(cardapioDTO.getProdutos().get(i));
			
			produtosCardapioService.alterar(pc);
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/cardapio/{id}")
	public ResponseEntity<?> removerCardapio(@PathVariable Integer id){
		Cardapio cardapioEncontrado = cardapioService.buscarPorId(id).get();
		if(cardapioEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		} else {
			
			List<ProdutosCardapio> produtosCardapio = produtosCardapioService.buscarPorCardapioId(cardapioEncontrado.getId());
			
			for(int i = 0; i < produtosCardapio.size(); i++) {
				produtosCardapioService.remover(produtosCardapio.get(i).getId());
			}
			
			cardapioService.remover(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}*/

}