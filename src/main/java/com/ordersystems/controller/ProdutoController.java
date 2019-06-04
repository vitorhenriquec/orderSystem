package com.ordersystems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.ordersystems.domain.Produto;

public interface ProdutoController {
	public ResponseEntity<?> buscarProdutos();
	public <T extends Produto> ResponseEntity<?> adicionarProduto(@RequestBody T produto);
	public ResponseEntity<?> removerProduto(@PathVariable Integer id);
}
