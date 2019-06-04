package com.ordersystems.service;

public class RegraPromocaoValor implements RegraPromocao{

	@Override
	public double calcularDesconto(double valorPedido) {
		return (double) (valorPedido - (valorPedido*0.1));
	}
}
