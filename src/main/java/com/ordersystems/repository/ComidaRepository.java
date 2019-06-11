package com.ordersystems.repository;

import com.ordersystems.domain.Comida;
//import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface ComidaRepository extends ProdutoRepository<Comida>{

}
