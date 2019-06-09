package com.ordersystems.service;

import java.util.Map;

public interface RegraPromocao {
	public double calcularDesconto(double valorPedido);
	public Map<String,String> gerarInformacao(double valorPedido);
}
