package com.ordersystems.domain;

import javax.persistence.Entity;

@Entity
public class Lavagem extends Produto{
	
	private String descricao;
	
	public Lavagem(){
	}
	
	public Lavagem(String nome, double preco, String descricao){
		this.setNome(nome);
		this.setPreco(preco);
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
