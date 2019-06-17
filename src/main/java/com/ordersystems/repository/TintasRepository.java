package com.ordersystems.repository;

import com.ordersystems.domain.Tintas;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TintasRepository extends ProdutoRepository<Tintas> {

}
