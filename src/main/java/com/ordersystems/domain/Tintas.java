package com.ordersystems.domain;

import javax.persistence.Entity;

@Entity
public class Tintas extends Produto{
	
	
	private String cor;
	
	
	private String tipoTinta;
	
	
	public Tintas() {
		
	}

	public Tintas(String nome, double preco,String cor, String tipoTinta) {
		this.setNome(nome);
		this.setPreco(preco);
		this.setCor(cor);
		this.setTipoTinta(tipoTinta);
	}

	public String getTipoTinta() {
		return tipoTinta;
	}

	public void setTipoTinta(String tipoTinta) {
		this.tipoTinta = tipoTinta;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

}
