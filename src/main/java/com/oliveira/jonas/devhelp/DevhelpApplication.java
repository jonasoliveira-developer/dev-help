package com.oliveira.jonas.devhelp;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.oliveira.jonas.devhelp.domain.Chamados;
import com.oliveira.jonas.devhelp.domain.Cliente;
import com.oliveira.jonas.devhelp.domain.Tecnico;
import com.oliveira.jonas.devhelp.domain.enuns.Perfil;
import com.oliveira.jonas.devhelp.domain.enuns.Prioridade;
import com.oliveira.jonas.devhelp.domain.enuns.Status;
import com.oliveira.jonas.devhelp.repositories.ChamadoRepository;
import com.oliveira.jonas.devhelp.repositories.ClienteRepository;
import com.oliveira.jonas.devhelp.repositories.TecnicoRepository;

@SpringBootApplication
public class DevhelpApplication implements CommandLineRunner {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	
	

	public static void main(String[] args) {
		SpringApplication.run(DevhelpApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico tec1 = new Tecnico(null, "Jonas Oliveira", "028.508.500-04", "jonas@gmail.com", "123");
		tec1.addPerfis(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente(null, "Jose da silva", "696.849.290-30", "jose@gmail.com", "123");
		
		Chamados cham1 = new Chamados(null, Prioridade.MEDIA, Status.ANDAMENTO, "cham1","Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(cham1));
	}

}
