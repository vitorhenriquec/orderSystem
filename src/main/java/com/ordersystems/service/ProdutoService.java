package com.ordersystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Produto;
import com.ordersystems.repository.PedidoRepository;

@Service
public class ProdutoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Produto> buscarTodos(){
		return pedidoRepository.findAll();
	}
	
	public Optional<Produto> buscarPorId(int id) {
		return pedidoRepository.findById(id);
	}
	
	public void adicionar(Produto produto) {
		pedidoRepository.save(produto);
	}
	
	public void salvar(Produto produto) {
		pedidoRepository.save(produto);
	}
	
	public void remover(int id) {
		pedidoRepository.deleteById(id);
	}
}
