package com.oliveira.jonas.devhelp.services;

import java.util.Optional;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveira.jonas.devhelp.domain.Chamados;
import com.oliveira.jonas.devhelp.repositories.ChamadoRepository;
import com.oliveira.jonas.devhelp.services.exceptions.ObjectNotFoundException;



@Service
public class ChamadoService {
	
	@Autowired
	private ChamadoRepository repository;
	
	public Chamados findById(Integer id) {
		Optional<Chamados> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id));
	}

	public List<Chamados> findAll() {
		return repository.findAll();
	}
	
	
}
