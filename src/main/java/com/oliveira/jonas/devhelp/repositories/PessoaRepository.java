package com.oliveira.jonas.devhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.jonas.devhelp.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
}
