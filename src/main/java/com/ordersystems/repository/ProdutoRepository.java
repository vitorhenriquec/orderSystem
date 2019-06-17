package com.ordersystems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.ordersystems.domain.Produto;

@NoRepositoryBean
public interface ProdutoRepository<T extends Produto> extends JpaRepository<T, Integer>{
	Optional<T> findById(int id);
}