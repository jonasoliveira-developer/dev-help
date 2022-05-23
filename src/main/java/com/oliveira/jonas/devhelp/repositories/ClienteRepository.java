package com.oliveira.jonas.devhelp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.oliveira.jonas.devhelp.domain.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
}
