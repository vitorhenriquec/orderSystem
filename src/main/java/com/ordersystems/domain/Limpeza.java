package com.ordersystems.domain;

import javax.persistence.Entity;

@Entity
public class Limpeza extends Produto{
	
	private String descricao;
	
	public Limpeza(){
	}
	
	public Limpeza(String descricao){
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
