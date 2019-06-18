package com.ordersystems.service;

import com.ordersystems.domain.Comida;
import com.ordersystems.exception.NegocioException;

public class ComidaService extends Service<Comida>{
	
	@Override
	public void adicionar(Comida produto) throws NegocioException {
		// TODO Auto-generated method stub
		if(produto.getNome() == null) {	
			throw new NegocioException("O campo 'Nome do Produto' está vázio");
		}
		else if(produto.getPreco() == null) {
			throw new NegocioException("Campo de entrada vázio");
		}
		else {
			comidaRepository.save(produto);
		}
	}

}
