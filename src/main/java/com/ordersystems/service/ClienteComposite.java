package com.ordersystems.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;

import com.ordersystems.domain.Cliente;

public class ClienteComposite extends ClienteService {
	
	ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	 @Override
	 public void adicionar(Cliente novoCliente) {
		 this.clientes.add(novoCliente);
	 }
	 
	@Autowired
	public void remover(String cpfClienteRemover){
		 for (Cliente c : clientes) {
			 if (c.getCpf() == cpfClienteRemover) {
				 this.clientes.remove(c);
				 return;
			 }
		 }
	}
	
	public Cliente getCliente(String cpf){
		
		for (Cliente c : clientes) {
			  if (c.getCpf() == cpf) {
				  return c;
			  }
		   }
		return null;
	}

	
	

}
