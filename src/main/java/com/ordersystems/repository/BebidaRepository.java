package com.ordersystems.repository;

import com.ordersystems.domain.Bebida;
//import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface BebidaRepository extends ProdutoRepository<Bebida>{

}
