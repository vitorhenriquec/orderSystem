package com.ordersystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Restaurante;
import com.ordersystems.exception.NegocioException;
import com.ordersystems.repository.RestauranteRepository;

@Service
public class RestauranteService {
	@Autowired
	RestauranteRepository restauranteRepository;
	
	public List<Restaurante> buscarTodos(){
		return restauranteRepository.findAll();
	}
	
	public Optional<Restaurante> buscarPorId(int id) {
		return restauranteRepository.findById(id);
	}
	
	public void adicionar(Restaurante restaurante) throws NegocioException {
		if(this.buscarTodos().size() == 0)	
			this.salvar(restaurante);
		else
			throw new NegocioException("Já existe um restaurante cadastrado.");
	}
	
	public void alterar(Restaurante restaurante) {
		this.salvar(restaurante);
	}
	
	private void salvar(Restaurante restaurante){
		restauranteRepository.save(restaurante);
	}
	
	public void remover(int id) {
		restauranteRepository.deleteById(id);
	}
}
