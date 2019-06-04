package com.ordersystems.service;

public class RegraPromocaoProduto implements RegraPromocao{

	@Override
	public double calcularDesconto(double valorPedido) {
		return (double) (valorPedido - (valorPedido*0.05));
	}

}
