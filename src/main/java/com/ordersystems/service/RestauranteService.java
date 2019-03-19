package com.ordersystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Restaurante;
import com.ordersystems.repository.RestauranteRepository;

@Service
public class RestauranteService {
	@Autowired
	RestauranteRepository resturanteRepository;
	
	public List<Restaurante> buscarTodos(){
		return resturanteRepository.findAll();
	}
	
	public Optional<Restaurante> buscarPorId(int id) {
		return resturanteRepository.findById(id);
	}
	
	public void adicionar(Restaurante restaurante) {
		resturanteRepository.save(restaurante);
	}
	
	public void salvar(Restaurante restaurante) {
		resturanteRepository.save(restaurante);
	}
	
	public void remover(int id) {
		resturanteRepository.deleteById(id);
	}
}
