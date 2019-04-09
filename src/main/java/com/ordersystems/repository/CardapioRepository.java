package com.ordersystems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ordersystems.domain.Cardapio;

@Repository
public interface CardapioRepository extends JpaRepository<Cardapio, Integer>{
	Optional<Cardapio> findById(int id);
	
	@Query("SELECT c FROM Cardapio c WHERE c.ativo IS TRUE")
	Optional<Cardapio> findActive();
}
