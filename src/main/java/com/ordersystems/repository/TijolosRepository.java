package com.ordersystems.repository;

import org.springframework.transaction.annotation.Transactional;

import com.ordersystems.domain.Tijolos;

@Transactional
public interface TijolosRepository extends ProdutoRepository<Tijolos> {

}
