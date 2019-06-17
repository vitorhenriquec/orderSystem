package com.ordersystems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Lavagem;
import com.ordersystems.domain.Limpeza;
import com.ordersystems.domain.Produto;
import com.ordersystems.exception.NegocioException;
import com.ordersystems.repository.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	private ProdutoRepository<Lavagem> lavagemRepository;
	
	@Autowired
	private ProdutoRepository<Limpeza> limpezaRepository;

	
	public List<Produto> buscarTodos(){
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.addAll(this.buscarLimpeza());
		produtos.addAll(this.buscarLavagem());
		return produtos;
	}
	
	public Produto buscarPorId(int id) {
		Produto produtoEncontrado = null;
		produtoEncontrado = limpezaRepository.findById(id).get();
		if(produtoEncontrado == null) {
			produtoEncontrado = lavagemRepository.findById(id).get();
		}
		return produtoEncontrado;
	}
	
	private List<Limpeza> buscarLimpeza(){
		return limpezaRepository.findAll();
	}
	
	private List<Lavagem> buscarLavagem(){
		return lavagemRepository.findAll();
	}
	
	
	public <T extends Produto> void adicionar(T produto) throws NegocioException {
		if(produto.getNome() == null) {	
			throw new NegocioException("O campo 'Nome do Produto' está vázio");
		}
		else if(produto.getPreco() == null) {
			throw new NegocioException("Campo de entrada vázio");
		}
		else {
			if(produto instanceof Limpeza) {
				limpezaRepository.save((Limpeza) produto);
			}
			else if(produto instanceof Lavagem){
				lavagemRepository.save((Lavagem) produto);
			}
		}
	}
	
	public void remover(int id) {
		limpezaRepository.deleteById(id);
		lavagemRepository.deleteById(id);

	}
}
