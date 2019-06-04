package com.ordersystems.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Comida extends Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	private double peso;
	
	private String validade;
	
	public Comida() {
		
	}

	public Comida(String nome, double preco,double peso, String validade) {
		super(nome,preco);
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
