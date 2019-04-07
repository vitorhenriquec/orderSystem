package com.ordersystems.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "mesa")
public class Mesa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="denominacao")
	private String denominacao;
	
	@OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,mappedBy = "mesa")
	private List<Pedido> pedidos = new ArrayList<Pedido>();
	
	@ManyToOne
	@JoinColumn(name = "restaurante_id")
	private Restaurante restaurante;
	
	public Mesa() {
		
	}
	
	public Mesa(int id, String denominacao) {
		super();
		this.id = id;
		this.denominacao = denominacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDenominacao() {
		return denominacao;
	}
	public void setDenominacao(String denominacao) {
		this.denominacao = denominacao;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setPedido(List<Pedido> pedidos) {
		this.pedidos = pedidos;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
			
}
