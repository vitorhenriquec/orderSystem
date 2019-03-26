package com.ordersystems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ordersystems.domain.ProdutosCardapio;

@Repository
public interface ProdutosCardapioRepository extends JpaRepository<ProdutosCardapio, Integer> {
	Optional<ProdutosCardapio> findById(int id);
	
	@Query("SELECT pc FROM ProdutosCardapio pc WHERE pc.cardapio.id = :id")
	Optional<List<ProdutosCardapio>> findByCardapioId(int id);
}
