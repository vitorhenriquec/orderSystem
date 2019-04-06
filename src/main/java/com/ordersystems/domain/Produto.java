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
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="nome")
	private String nome;
	
	@Column(name="preco")
	private Double preco;
	
	@ManyToMany(cascade = {
			CascadeType.PERSIST,
            CascadeType.MERGE
        })
	@JoinTable(name = "produto_pedido",
    joinColumns = { @JoinColumn(name = "produto_id") },
    inverseJoinColumns = { @JoinColumn(name = "pedido_id") })
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	@ManyToMany(cascade = {
				CascadeType.PERSIST,
                CascadeType.MERGE
            })
	@JoinTable(name = "produto_cardapio",
    joinColumns = { @JoinColumn(name = "produto_id") },
    inverseJoinColumns = { @JoinColumn(name = "cardapio_id") })
	private List<Cardapio> cardapios;
	
	public Produto() {}

	public Produto(int id, String nome, Double preco) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}

	public List<Pedido> getPedido() {
		return pedidos;
	}

	public void setPedido(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public List<Cardapio> getCardapios() {
		return cardapios;
	}

	public void setCardapios(List<Cardapio> cardapios) {
		this.cardapios = cardapios;
	}
	
}
