package com.ordersystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.ProdutosCardapio;
import com.ordersystems.repository.ProdutosCardapioRepository;

@Service
public class ProdutosCardapioService {
	@Autowired
	ProdutosCardapioRepository produtosCardapioRepository;
	
	public List<ProdutosCardapio> buscarTodos(){
		return produtosCardapioRepository.findAll();
	}
	
	public Optional<ProdutosCardapio> buscarPorId(int id) {
		return produtosCardapioRepository.findById(id);
	}
	
	public void adicionar(ProdutosCardapio pc) {
		produtosCardapioRepository.save(pc);
	}
	
	public void remover(int id) {
		produtosCardapioRepository.deleteById(id);
	}
	
	public List<ProdutosCardapio> buscarPorCardapioId(int id) {
		return produtosCardapioRepository.findByCardapioId(id).get();
	}
	
	public void alterar(ProdutosCardapio pc) {
		produtosCardapioRepository.save(pc);
	}
}
