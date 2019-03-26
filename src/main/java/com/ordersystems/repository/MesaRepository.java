package com.ordersystems.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ordersystems.domain.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Integer>{
	Optional<Mesa> findById(int id);
}
