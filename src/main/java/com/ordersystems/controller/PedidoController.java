package com.ordersystems.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ordersystems.domain.EstadoPedido;
import com.ordersystems.domain.Mesa;
import com.ordersystems.domain.Pedido;
import com.ordersystems.domain.Produto;
import com.ordersystems.service.MesaService;
import com.ordersystems.service.PedidoService;
import com.ordersystems.service.ProdutoService;
import com.ordersystems.service.RegraPromocao;
import com.ordersystems.service.RegraPromocaoProduto;
import com.ordersystems.service.RegraPromocaoValor;

@RestController
public class PedidoController {
	@Autowired
	PedidoService pedidoService;
	
	@Autowired
	ProdutoService produtoService;
	
	@Autowired
	MesaService mesaService;
	
	RegraPromocao regra;
	
	@RequestMapping(method=RequestMethod.GET,value="/pedido",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarTodos(){
		return new ResponseEntity<>(pedidoService.buscarTodos(),HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.GET,value="/pedido/mesa/{idMesa}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> buscarPedidosMesa(@PathVariable Integer idMesa){
		List<Pedido> pedidosMesa = new ArrayList<Pedido>();
		pedidosMesa = pedidoService.buscarPorMesaId(idMesa);
		return new ResponseEntity<>(pedidosMesa,HttpStatus.OK);
	}
		
	@RequestMapping(method=RequestMethod.POST,value="/pedido",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> adicionarPedido(@RequestBody Pedido pedido){
		List<Produto> produtos = new ArrayList<Produto>();
		pedido.setEstadoPedido(EstadoPedido.AGUARDANDO);
		try{
			Mesa mesa = mesaService.buscarPorId(pedido.getMesa().getId()).get();
				
			for(Produto produto : pedido.getProdutos()) {
				Produto produtoDB = produtoService.buscarPorId(produto.getId()).get();
				produtoDB.getPedido().add(pedido);
				produtos.add(produtoDB);
			}
			
			pedido.setMesa(mesa);
			pedido.setProdutos(produtos);
			pedidoService.adicionar(pedido);
			
			return new ResponseEntity<>(HttpStatus.CREATED);
		}
		catch(Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/mudarEstado",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> mudarEstado(@RequestBody Pedido pedido){
		try {
			Pedido pedidoEncontrado = pedidoService.buscarPorId(pedido.getId()).get();
			if(pedidoEncontrado != null) {
				pedidoEncontrado.setEstadoPedido(pedido.getEstadoPedido());
				pedidoService.salvar(pedidoEncontrado);
				return new ResponseEntity<>(HttpStatus.CREATED);
			}
			else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/pedido/{id}")
	public ResponseEntity<?> removerPedido(@PathVariable Integer id){
		Pedido pedidoEncontrado = pedidoService.buscarPorId(id).get();
		if(pedidoEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		else {
			pedidoService.remover(id);
			return new ResponseEntity<>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/desconto",consumes = MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> verificarDesconto(@RequestBody List<Pedido> pedidos){

		double valorPedido = 0.0;
		int quantProdutos = 0;
		for(Pedido pedido:pedidos) {
			Pedido pedidoEncontrado = pedidoService.buscarPorId(pedido.getId()).get();
			quantProdutos += pedidoEncontrado.getProdutos().size();
			for(Produto p:pedidoEncontrado.getProdutos()) {
				valorPedido+=p.getPreco();
			}
		
		}
		
		if(valorPedido > 50.0) {
			regra = new RegraPromocaoValor();
			return new ResponseEntity<>(regra.mensagem(valorPedido),HttpStatus.OK);
		}
		else {
			if(quantProdutos >= 3) {
				regra = new RegraPromocaoProduto();
				return new ResponseEntity<>(regra.mensagem(valorPedido),HttpStatus.OK);
			}
			Map<String, String> pedidoSemPromocao = new HashMap<String, String>();
			pedidoSemPromocao.put("valorFinal",String.valueOf(valorPedido));
			return new ResponseEntity<>(pedidoSemPromocao,HttpStatus.OK);	
		}
		
		
	}
}
