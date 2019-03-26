package com.ordersystems.dto;

import java.util.List;

import com.ordersystems.domain.Cardapio;
import com.ordersystems.domain.Produto;

public class CardapioDTO {
	private Cardapio cardapio;

	private List<Produto> produtos;
	
	public CardapioDTO() {
		super();
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
}
