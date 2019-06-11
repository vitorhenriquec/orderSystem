package com.ordersystems.domain;


import javax.persistence.Entity;

@Entity
public class Comida extends Produto{

	private double peso;
	
	private String validade;
	
	public Comida() {
		
	}

	public Comida(String nome, double preco,double peso, String validade) {
		this.setNome(nome);
		this.setPreco(preco);
		this.peso = peso;
		this.validade = validade;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}
	
}
