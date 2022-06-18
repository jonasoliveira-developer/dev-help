package com.oliveira.jonas.devhelp.services;

import java.util.Optional;

import javax.validation.Valid;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveira.jonas.devhelp.domain.Chamados;
import com.oliveira.jonas.devhelp.domain.Cliente;
import com.oliveira.jonas.devhelp.domain.Tecnico;
import com.oliveira.jonas.devhelp.domain.dtos.ChamadoDTO;
import com.oliveira.jonas.devhelp.domain.enuns.Prioridade;
import com.oliveira.jonas.devhelp.domain.enuns.Status;
import com.oliveira.jonas.devhelp.repositories.ChamadoRepository;
import com.oliveira.jonas.devhelp.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository repository;
	@Autowired
	private TecnicoService tecnicoService;
	@Autowired
	private ClienteService clienteService;

	public Chamados findById(Integer id) {
		Optional<Chamados> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! " + id));
	}

	public List<Chamados> findAll() {
		return repository.findAll();
	}

	public Chamados create(@Valid ChamadoDTO objDTO) {
		return repository.save(newChamado(objDTO));
	}

	private Chamados newChamado(ChamadoDTO obj) {

		Tecnico tecnico = tecnicoService.findById(obj.getTecnico());
		Cliente cliente = clienteService.findById(obj.getCliente());

		Chamados chamados = new Chamados();
		if (obj.getId() != null) {
			chamados.setId(obj.getId());
		}

		chamados.setTecnico(tecnico);
		chamados.setCliente(cliente);
		chamados.setPrioridade(Prioridade.toEnum(obj.getPrioridade()));
		chamados.setStatus(Status.toEnum(obj.getStatus()));
		chamados.setTitulo(obj.getTitulo());
		chamados.setOrientacoes(obj.getOrientacoes());
		return chamados;
	}

}
