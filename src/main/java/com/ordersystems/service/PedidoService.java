package com.ordersystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Pedido;
import com.ordersystems.repository.PedidoRepository;

@Service
public class PedidoService {
	@Autowired
	PedidoRepository pedidoRepository;
	
	public List<Pedido> buscarTodos(){
		return pedidoRepository.findAll();
	}
	
	public Optional<Pedido> buscarPorId(int id) {
		return pedidoRepository.findById(id);
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
}
