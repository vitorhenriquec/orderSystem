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
		if(this.buscarTodos().size() != 0)
			throw new NegocioException("Já existe um restaurante cadastrado.");
		
		else if(restaurante.getNome() == null)
			throw new NegocioException("O campo 'Nome' está vázio");
		
		else if(restaurante.getTelefone() == null)
			throw new NegocioException("O campo 'Telefone' está vázio");
		
		else if(restaurante.getRua() == null)
			throw new NegocioException("O campo 'Rua' está vázio");
		
		else if(restaurante.getBairro() == null)
			throw new NegocioException("O campo 'Bairro' está vázio");
		
		else if(restaurante.getCidade() == null)
			throw new NegocioException("O campo 'Cidade' está vázio");
		
		else
			this.salvar(restaurante);
			
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
