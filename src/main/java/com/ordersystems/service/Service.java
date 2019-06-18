package com.ordersystems.service;

import com.ordersystems.domain.Produto;
import com.ordersystems.exception.NegocioException;

public abstract class Service<T extends Produto> extends ProdutoService{
	public abstract void adicionar(T produto) throws NegocioException;
}
