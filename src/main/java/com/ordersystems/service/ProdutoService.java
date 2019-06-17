package com.ordersystems.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ordersystems.domain.Produto;
import com.ordersystems.domain.Tijolos;
import com.ordersystems.domain.Tintas;
import com.ordersystems.exception.NegocioException;
import com.ordersystems.repository.ProdutoRepository;

@Service
public class ProdutoService {


	@Autowired
	private ProdutoRepository<Tintas> tintasRepository;
	
	@Autowired
	private ProdutoRepository<Tijolos> tijolosRepository;
	
	public List<Produto> buscarTodos(){
		List<Produto> produtos = new ArrayList<Produto>();
		produtos.addAll(this.buscarTijolos());
		produtos.addAll(this.buscarTintas());
		return produtos;
	}
	
	public Produto buscarPorId(int id) {
		Produto produtoEncontrado = null;
		produtoEncontrado = tintasRepository.findById(id).get();
		if(produtoEncontrado == null) {
			produtoEncontrado = tijolosRepository.findById(id).get();
		}
		return produtoEncontrado;
	}
	
	private List<Tintas> buscarTintas(){
		return tintasRepository.findAll();
	}
	
	private List<Tijolos> buscarTijolos(){
		return tijolosRepository.findAll();
	}
	
	public <T extends Produto> void adicionar(T produto) throws NegocioException {
		if(produto.getNome() == null) {	
			throw new NegocioException("O campo 'Nome do Produto' está vázio");
		}
		else if(produto.getPreco() == null) {
			throw new NegocioException("Campo de entrada vázio");
		}
		else {
			if(produto instanceof Tintas) {
				tintasRepository.save((Tintas) produto);
			}
			else if(produto instanceof Tijolos){
				tijolosRepository.save((Tijolos) produto);
			}
		}
	}
		
	public void remover(int id) {
			tijolosRepository.deleteById(id);
			tintasRepository.deleteById(id);
	}
}
