package com.ordersystems.service;

import java.util.HashMap;
import java.util.Map;

public class MediaValor implements RegraPromocao{

	@Override
	public double calcularDesconto(double valorPedido) {
		return(double) (valorPedido - (valorPedido*0.1));
	}

	@Override
	public Map<String, String> gerarInformacao(double valorPedido) {
		Map<String, String> dict = new HashMap<String, String>();
		String mensagem= "Promoção dos 1%: A sua compra teve uma média de valor para os produtos únicos comprados acima de $60.00. O valor da compra teve 1% de desconto";
		String valorTotal = String.valueOf(valorPedido);
		String valorFinal = String.valueOf(this.calcularDesconto(valorPedido));
		dict.put("mensagem", mensagem);
		dict.put("valorTotal", valorTotal);
		dict.put("valorFinal", valorFinal);
		return dict;
	}

}
