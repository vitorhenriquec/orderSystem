package com.ordersystems.domain;
import javax.persistence.Entity;

@Entity
public class Tijolos extends Produto{
	
	private String tipo;

	public Tijolos() {
		
	}
	
	public Tijolos(String nome, double preco, String tipo) {
		this.setNome(nome);
		this.setPreco(preco);
		this.tipo = tipo;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
}
