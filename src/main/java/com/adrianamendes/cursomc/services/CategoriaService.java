package com.adrianamendes.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adrianamendes.cursomc.domain.Categoria;
import com.adrianamendes.cursomc.repositories.CategoriaRepository;
import com.adrianamendes.cursomc.services.exceptions.ObjectNotFountException;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;

	public Categoria find(Integer id) {
		Optional<Categoria> obj = repo.findById(id);
		if(!obj.isPresent()) {
			throw new ObjectNotFountException("Objeto não encontrado! Id: " + id + "Tipo: " + Categoria.class.getName());
		}
		return obj.get();
	}
}
