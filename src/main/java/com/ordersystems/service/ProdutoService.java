package com.ordersystems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Bebida;
import com.ordersystems.domain.Comida;
import com.ordersystems.domain.Produto;
import com.ordersystems.repository.ProdutoRepository;

@Service
public class ProdutoService{
	
	@Autowired
	protected ProdutoRepository<Comida> comidaRepository;
	
	@Autowired
	protected ProdutoRepository<Bebida> bebidaRepository;
	
	public List<Produto> buscarTodos(){
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.addAll(this.buscarBebidas());
		produtos.addAll(this.buscarComidas());
		return produtos;
	}
	
	public Produto buscarPorId(int id) {
		Produto produtoEncontrado = null;
		produtoEncontrado = bebidaRepository.findById(id).get();
		if(produtoEncontrado == null) {
			produtoEncontrado = comidaRepository.findById(id).get();
		}
		return produtoEncontrado;
	}
	
	private List<Bebida> buscarBebidas(){
		return bebidaRepository.findAll();
	}
	
	private List<Comida> buscarComidas(){
		return comidaRepository.findAll();
	}
	
	public void remover(int id) {
		bebidaRepository.deleteById(id);
		comidaRepository.deleteById(id);
	}
}
