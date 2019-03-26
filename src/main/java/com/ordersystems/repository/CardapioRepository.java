package com.ordersystems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordersystems.domain.Cardapio;
import com.ordersystems.domain.Produto;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Integer>{
	Optional<Cardapio> findById(int id);
}
