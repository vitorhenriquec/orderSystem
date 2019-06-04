package com.ordersystems.domain;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class Bebida extends Produto implements Serializable{

	private static final long serialVersionUID = 1L;

	private String marca;
	
	private double litros;
	
	private String validade;
	
	public Bebida() {
		
	}

	public Bebida(String nome, double preco,String marca, double litros,String validade) {
		this.setNome(nome);
		this.setPreco(preco);
		this.marca = marca;
		this.litros = litros;
		this.validade = validade;
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

	public String getValidade() {
		return validade;
	}

	public void setValidade(String validade) {
		this.validade = validade;
	}
	
	
}
