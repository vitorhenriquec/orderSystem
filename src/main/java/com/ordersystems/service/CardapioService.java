package com.ordersystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Cardapio;
import com.ordersystems.repository.CardapioRepository;

@Service
public class CardapioService {
	
	@Autowired
	CardapioRepository cardapioRepository;
	
	public List<Cardapio> buscarTodos(){
		return cardapioRepository.findAll();
	}
	
	public Cardapio buscarAtivo() {
		return cardapioRepository.findActive().get();
	}
	
	public Optional<Cardapio> buscarPorId(int id) {
		return cardapioRepository.findById(id);
	}
	
	public void adicionar(Cardapio cardapio) {
		cardapioRepository.save(cardapio);
	}
	
	public void remover(int id) {
		cardapioRepository.deleteById(id);
	}
	
	public void alterar(Cardapio cardapio) {
		cardapioRepository.save(cardapio);
	}

}
