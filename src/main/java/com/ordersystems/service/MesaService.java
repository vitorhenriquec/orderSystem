package com.ordersystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Mesa;
import com.ordersystems.exception.NegocioException;
import com.ordersystems.repository.MesaRepository;

@Service
public class MesaService {
	
	@Autowired
	MesaRepository mesaRepository;
	
	public List<Mesa> buscarTodos(){
		return mesaRepository.findAll();
	}
	
	public Optional<Mesa> buscarPorId(int id) {
		return mesaRepository.findById(id);
	}
	
	public void adicionar(Mesa mesa) throws NegocioException{
		if(mesa.getDenominacao() == null)	
			throw new NegocioException("O campo 'Denominação das Mesas' está vázio");
			
		this.salvar(mesa);
	}
	
	public void salvar(Mesa mesa) {
		mesaRepository.save(mesa);
	}
	
	public void remover(int id) {
		mesaRepository.deleteById(id);
	}

}
