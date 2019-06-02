package com.ordersystems.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Comida extends Produto{

	private static final long serialVersionUID = 1L;

	private double peso;
	
	private Date validade;

	public Comida(String nome, double preco,double peso, Date validade) {
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

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
}
