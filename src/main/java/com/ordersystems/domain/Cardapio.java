package com.ordersystems.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cardapio")
public class Cardapio implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="nome")
	private String nome;
	
	@ManyToMany(cascade = {
			CascadeType.MERGE,
			CascadeType.DETACH,
			CascadeType.PERSIST,
			CascadeType.REFRESH
        })
	@JoinTable(name = "cardapio_produto",
	joinColumns = { @JoinColumn(name = "cardapio_id", referencedColumnName = "id") },
	inverseJoinColumns = { @JoinColumn(name = "produto_id", referencedColumnName = "id") })
	private List<Produto> produtos = new ArrayList<Produto>();
	
	@ManyToOne
	@JoinColumn(name = "restaurante_id", nullable=false)
	private Restaurante restaurante;
	
	@Column(name="ativo")
	private boolean ativo = false;
	
	public Cardapio() {

	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
