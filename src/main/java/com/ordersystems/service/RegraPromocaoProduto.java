package com.ordersystems.service;

import java.util.HashMap;
import java.util.Map;

public class RegraPromocaoProduto implements RegraPromocao{

	@Override
	public double calcularDesconto(double valorPedido) {
		return(double) (valorPedido - (valorPedido*0.05));
	}

	@Override
	public Map<String, String> gerarInformacao(double valorPedido) {
		Map<String, String> dict = new HashMap<String, String>();
		String mensagem= "Promoção dos 5%: A quantidade produtos comprados foi maior do que 2 e o valor da compra teve 5% de desconto";
		String valorTotal = String.valueOf(valorPedido);
		String valorFinal = String.valueOf(this.calcularDesconto(valorPedido));
		dict.put("mensagem", mensagem);
		dict.put("valorTotal", valorTotal);
		dict.put("valorFinal", valorFinal);
		return dict;
	}

}
