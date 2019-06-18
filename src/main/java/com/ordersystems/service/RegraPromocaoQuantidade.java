package com.ordersystems.service;

import java.util.HashMap;
import java.util.Map;

public class RegraPromocaoQuantidade implements RegraPromocao{

	@Override
	public double calcularDesconto(double valorPedido) {
		return(double) (valorPedido - (valorPedido*0.03));
	}

	@Override
	public Map<String, String> gerarInformacao(double valorPedido) {
		Map<String, String> dict = new HashMap<String, String>();
		String mensagem= "Promoção dos 3%: A sua compra tem mais do que 4 produtos diferentes e o valor da compra teve 3% de desconto";
		String valorTotal = String.valueOf(valorPedido);
		String valorFinal = String.valueOf(this.calcularDesconto(valorPedido));
		dict.put("mensagem", mensagem);
		dict.put("valorTotal", valorTotal);
		dict.put("valorFinal", valorFinal);
		return dict;
	}

}
