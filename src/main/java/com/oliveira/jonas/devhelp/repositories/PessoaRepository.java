package com.oliveira.jonas.devhelp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.jonas.devhelp.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	Optional<Pessoa>findByCpf(String cpf);
	Optional<Pessoa>findByEmail(String email);
		
	
}
