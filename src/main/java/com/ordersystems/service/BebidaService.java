package com.ordersystems.service;
import com.ordersystems.domain.Bebida;
import com.ordersystems.exception.NegocioException;


public class BebidaService extends Service<Bebida>{

	@Override
	public void adicionar(Bebida produto) throws NegocioException{
		if(produto.getNome() == null) {	
			throw new NegocioException("O campo 'Nome do Produto' está vázio");
		}
		else if(produto.getPreco() == null) {
			throw new NegocioException("Campo de entrada vázio");
		}
		else {
			bebidaRepository.save(produto);
		}
	}

}
