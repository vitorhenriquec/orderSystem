package com.ordersystems.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ordersystems.domain.Funcionario;
import com.ordersystems.repository.FuncionarioRepository;

@Service
public class FuncionarioService {
	@Autowired
	FuncionarioRepository funcionarioRepository;
	
	public List<Funcionario> buscarTodos(){
		return funcionarioRepository.findAll();
	}
	
	public Optional<Funcionario> buscarPorId(int id) {
		return funcionarioRepository.findById(id);
	}
	
	public void adicionar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
	public void salvar(Funcionario funcionario) {
		funcionarioRepository.save(funcionario);
	}
	
	public void remover(int id) {
		funcionarioRepository.deleteById(id);
	}
}
