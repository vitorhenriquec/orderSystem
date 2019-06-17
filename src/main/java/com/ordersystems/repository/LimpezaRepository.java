package com.ordersystems.repository;

import org.springframework.transaction.annotation.Transactional;
import com.ordersystems.domain.Limpeza;

@Transactional
public interface LimpezaRepository extends ProdutoRepository<Limpeza>{
}
