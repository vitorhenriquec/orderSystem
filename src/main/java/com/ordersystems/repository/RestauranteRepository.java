package com.ordersystems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordersystems.domain.Restaurante;

@Repository
public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{
	Optional<Restaurante> findById(int id);
}
