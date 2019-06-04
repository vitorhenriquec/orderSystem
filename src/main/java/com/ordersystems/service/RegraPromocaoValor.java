package com.ordersystems.service;

import java.util.HashMap;
import java.util.Map;

public class RegraPromocaoValor implements RegraPromocao{

	@Override
	public double calcularDesconto(double valorPedido) {
		return (double) (valorPedido - (valorPedido*0.1));
	}

	@Override
	public Map<String, String> mensagem(double valorPedido) {
		Map<String, String> dict = new HashMap<String, String>();
		String mensagem= "Promoção dos 10%: O valor total da compra foi maior do que R$ 50 e teve 10% de desconto";
		String valorTotal = String.valueOf(valorPedido);
		String valorFinal = String.valueOf(this.calcularDesconto(valorPedido));
		dict.put("mensagem", mensagem);
		dict.put("valorTotal", valorTotal);
		dict.put("valorFinal", valorFinal);
		return dict;
	}
}
