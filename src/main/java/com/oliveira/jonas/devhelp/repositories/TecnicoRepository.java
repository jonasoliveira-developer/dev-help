package com.oliveira.jonas.devhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.jonas.devhelp.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer> {
	
}
