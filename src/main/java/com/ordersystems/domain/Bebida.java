package com.ordersystems.domain;

import java.util.Date;

import javax.persistence.Entity;

@Entity
public class Bebida extends Produto{

	private static final long serialVersionUID = 1L;

	private String marca;
	
	private double litros;
	
	private Date validade;

	public Bebida(String nome, double preco,String marca, double litos) {
		super(nome, preco);
		this.marca = marca;
		this.litros = litos;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getLitos() {
		return litros;
	}

	public void setLitos(double litros) {
		this.litros = litros;
	}

	public Date getValidade() {
		return validade;
	}

	public void setValidade(Date validade) {
		this.validade = validade;
	}
	
	
}
