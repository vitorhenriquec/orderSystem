package com.ordersystems.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "restaurante")
@JsonIgnoreProperties({"mesas","cardapios"})
public class Restaurante implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="nome")
	private String nome;
	
	@Column(name="telefone")
	private String telefone;
	
	@Column(name="rua")
	private String rua;
	
	@Column(name="bairro")
	private String bairro;
	
	@Column(name="cidade")
	private String cidade;
	
	@OneToMany(mappedBy = "restaurante")
	private List<Mesa> mesas;
	
	@OneToMany(mappedBy = "restaurante")
	private List<Cardapio> cardapios;

	public Restaurante() {

	}
	
	public Restaurante(int id, String nome, String telefone, String rua, String bairro, String cidade) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.rua = rua;
		this.bairro = bairro;
		this.cidade = cidade;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNomeRestaurante() {
		return nome;
	}

	public void setNomeRestaurante(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Cardapio> getCardapios() {
		return cardapios;
	}

	public void setCardapios(List<Cardapio> cardapios) {
		this.cardapios = cardapios;
	}
}
