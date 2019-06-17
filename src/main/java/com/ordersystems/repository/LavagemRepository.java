package com.ordersystems.repository;

import org.springframework.transaction.annotation.Transactional;
import com.ordersystems.domain.Lavagem;

@Transactional
public interface LavagemRepository extends ProdutoRepository<Lavagem>{
}
