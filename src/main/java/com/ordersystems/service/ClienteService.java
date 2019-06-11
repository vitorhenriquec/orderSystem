package com.ordersystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Cliente;
import com.ordersystems.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	public List<Cliente> buscarTodos(){
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> buscarPorId(int id) {
		return clienteRepository.findById(id);
	}
	
	public Optional<Cliente> buscarPorCpf(String cpf) {
		return clienteRepository.findByCpf(cpf);
	}
	
	public void adicionar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void salvar(Cliente cliente) {
		clienteRepository.save(cliente);
	}
	
	public void remover(int id) {
		clienteRepository.deleteById(id);
	}

}
