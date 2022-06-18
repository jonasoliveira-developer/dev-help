package com.oliveira.jonas.devhelp.resouces;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.oliveira.jonas.devhelp.domain.Chamados;
import com.oliveira.jonas.devhelp.domain.dtos.ChamadoDTO;
import com.oliveira.jonas.devhelp.services.ChamadoService;

@RestController
@RequestMapping(value = "chamados")
public class ChamadoResource {

	@Autowired
	private ChamadoService service;

	@GetMapping(value = "/{id}")
	public ResponseEntity<ChamadoDTO> findById(@PathVariable Integer id) {
		Chamados obj = service.findById(id);
		return ResponseEntity.ok().body(new ChamadoDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<ChamadoDTO>> findAll() {
		List<Chamados> list = service.findAll();

		List<ChamadoDTO> listDTO = list.stream().map(obj -> new ChamadoDTO(obj)).collect(Collectors.toList());

		return ResponseEntity.ok().body(listDTO);
	}

	@PostMapping
	public ResponseEntity<ChamadoDTO> create(@Valid @RequestBody ChamadoDTO objDTO) {
		Chamados obj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ChamadoDTO> update( @PathVariable Integer id,  @Valid @RequestBody ChamadoDTO objDTO){
		Chamados newObj = service.update(id,objDTO);
		
		return ResponseEntity.ok().body(new ChamadoDTO(newObj));
	}
	
	
	
	
	
	

}
