package com.ordersystems.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Pedido;
import com.ordersystems.domain.Produto;
import com.ordersystems.repository.PedidoRepository;


@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	private RegraPromocao regra;
	
	public List<Pedido> buscarTodos(){
		return pedidoRepository.findAll();
	}
	
	public Optional<Pedido> buscarPorId(int id) {
		return pedidoRepository.findById(id);
	}
	
	public List<Pedido> buscarPorMesaId(int id){
		return pedidoRepository.findByMesaId(id);
	}
	
	public void adicionar(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void salvar(Pedido pedido) {
		pedidoRepository.save(pedido);
	}
	
	public void remover(int id) {
		pedidoRepository.deleteById(id);
	}
	
	public Map<String, String> procurarPromocao(List<Pedido> pedidos){
		Map<String, String> criarInformacao = new HashMap<String, String>();
		criarInformacao.put("mensagem", "Sem promocao");
		criarInformacao.put("valorTotal", "0.0");
		criarInformacao.put("valorFinal", "0.0");
		
		double valorPedido = 0.0;
		int quantProdutos = 0;
		for(Pedido pedido:pedidos) {
			Pedido pedidoEncontrado = this.buscarPorId(pedido.getId()).get();
			quantProdutos += pedidoEncontrado.getProdutos().size();
			for(Produto p:pedidoEncontrado.getProdutos()) {
				valorPedido+=p.getPreco();
			}
		
		}
		
		if(valorPedido > 50.0) {
			regra = new RegraPromocaoValor();
			criarInformacao = regra.gerarInformacao(valorPedido);
		}
		else if(quantProdutos >= 3) {
			regra = new RegraPromocaoProduto();
			criarInformacao = regra.gerarInformacao(valorPedido);
		}
		else {
			criarInformacao.put("valorFinal",String.valueOf(valorPedido));
			criarInformacao.put("valorTotal",String.valueOf(valorPedido));	
		}
		return criarInformacao;
	}
}
