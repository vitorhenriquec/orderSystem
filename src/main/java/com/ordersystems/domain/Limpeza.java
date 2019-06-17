package com.ordersystems.domain;

import javax.persistence.Entity;

@Entity
public class Limpeza extends Produto{
	
	private String descricao;
	
	public Limpeza(){
	}
	
	public Limpeza(String nome, double preco, String descricao){
		this.descricao = descricao;
		this.setNome(nome);
		this.setPreco(preco);
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
