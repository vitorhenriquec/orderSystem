package com.ordersystems.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Produto;
import com.ordersystems.repository.PedidoRepository;

@Service
public class ProdutoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Produto> findAll(){
		return pedidoRepository.findAll();
	}
	
	public void add(Produto produto) {
		pedidoRepository.save(produto);
	}
}
