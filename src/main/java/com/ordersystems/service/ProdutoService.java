package com.ordersystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Produto;
import com.ordersystems.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	ProdutoRepository produtoRepository;
	
	public List<Produto> buscarTodos(){
		return produtoRepository.findAll();
	}
	
	public Optional<Produto> buscarPorId(int id) {
		return produtoRepository.findById(id);
	}
	
	public void adicionar(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public void salvar(Produto produto) {
		produtoRepository.save(produto);
	}
	
	public void remover(int id) {
		produtoRepository.deleteById(id);
	}
}
