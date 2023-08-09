package com.adrianamendes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianamendes.cursomc.domain.Pedido;
import com.adrianamendes.cursomc.repositories.PedidoRepository;
import com.adrianamendes.cursomc.services.exceptions.ObjectNotFountException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido find(Integer id) {
		Optional<Pedido> obj = repo.findById(id);
		if(!obj.isPresent()) {
			throw new ObjectNotFountException("Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName());
		}
		return obj.get();
	}
}
