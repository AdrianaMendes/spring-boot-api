package com.adrianamendes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianamendes.cursomc.domain.Cliente;
import com.adrianamendes.cursomc.repositories.ClienteRepository;
import com.adrianamendes.cursomc.services.exceptions.ObjectNotFountException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) {
		Optional<Cliente> obj = repo.findById(id);
		if(!obj.isPresent()) {
			throw new ObjectNotFountException("Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName());
		}
		return obj.get();
	}
}
