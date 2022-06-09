package com.oliveira.jonas.devhelp.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveira.jonas.devhelp.domain.Chamados;
import com.oliveira.jonas.devhelp.domain.Cliente;
import com.oliveira.jonas.devhelp.domain.Tecnico;
import com.oliveira.jonas.devhelp.domain.enuns.Perfil;
import com.oliveira.jonas.devhelp.domain.enuns.Prioridade;
import com.oliveira.jonas.devhelp.domain.enuns.Status;
import com.oliveira.jonas.devhelp.repositories.ChamadoRepository;
import com.oliveira.jonas.devhelp.repositories.ClienteRepository;
import com.oliveira.jonas.devhelp.repositories.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Jonas Oliveira", "028.508.500-04", "jonas@gmail.com", "123");
		tec1.addPerfis(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Jose da silva", "696.849.290-30", "jose@gmail.com", "123");

		Chamados cham1 = new Chamados(null, Prioridade.MEDIA, Status.ANDAMENTO, "cham1", "Primeiro Chamado", tec1,
				cli1);
		
		Tecnico tec2 = new Tecnico(null, "Lucas Oliveira", "028.508.500-05", "lucas@gmail.com", "1234");
		tec1.addPerfis(Perfil.ADMIN);

		Cliente cli2 = new Cliente(null, "Mario da silva", "696.849.290-35", "mario@gmail.com", "1234	");

		Chamados cham2 = new Chamados(null, Prioridade.BAIXA, Status.ABERTO, "cham1", "Primeiro Chamado", tec2,
				cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		chamadoRepository.saveAll(Arrays.asList(cham1,cham2));
	}
}
