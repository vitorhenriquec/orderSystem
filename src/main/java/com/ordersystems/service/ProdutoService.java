package com.ordersystems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Bebida;
import com.ordersystems.domain.Comida;
import com.ordersystems.domain.Produto;
import com.ordersystems.exception.NegocioException;
import com.ordersystems.repository.ProdutoRepository;

@Service
public class ProdutoService {
	@Autowired
	private ProdutoRepository<Comida> comidaRepository;
	
	@Autowired
	private ProdutoRepository<Bebida> bebidaRepository;
	
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
	
	public <T extends Produto> void adicionar(T produto) throws NegocioException {
		if(produto.getNome() == null) {	
			throw new NegocioException("O campo 'Nome do Produto' está vázio");
		}
		else if(produto.getPreco() == null) {
			throw new NegocioException("Campo de entrada vázio");
		}
		else {
			if(produto instanceof Bebida) {
				bebidaRepository.save((Bebida) produto);
			}
			else if(produto instanceof Comida){
				comidaRepository.save((Comida) produto);
			}
		}
	}
		
	
	public void remover(int id) {
		bebidaRepository.deleteById(id);
		comidaRepository.deleteById(id);
	}
}
