package com.ordersystems.domain;

import javax.persistence.Entity;

@Entity
public class Bebida extends Produto{

	private static final long serialVersionUID = 1L;

	private String marca;
	
	private double Litos;

	public Bebida(String nome, double preco,String marca, double litos) {
		super(nome, preco);
		this.marca = marca;
		Litos = litos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getLitos() {
		return Litos;
	}

	public void setLitos(double litos) {
		Litos = litos;
	}
	
}
