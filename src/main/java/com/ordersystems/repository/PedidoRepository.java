package com.ordersystems.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ordersystems.domain.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
	Optional<Pedido> findById(int id);
	@Query(value="SELECT * FROM Pedido p WHERE p.mesa.id = ?1", nativeQuery = true)
	List<Pedido> findByMesaId(int idMesa);
}
