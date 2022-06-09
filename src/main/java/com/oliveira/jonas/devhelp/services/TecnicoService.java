package com.oliveira.jonas.devhelp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveira.jonas.devhelp.domain.Tecnico;
import com.oliveira.jonas.devhelp.repositories.TecnicoRepository;
import com.oliveira.jonas.devhelp.services.exceptions.ObjectNotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;

	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id));
	}
}
