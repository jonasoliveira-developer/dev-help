package com.oliveira.jonas.devhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.jonas.devhelp.domain.Chamados;


public interface ChamadoRepository extends JpaRepository<Chamados, Integer> {
	
}
