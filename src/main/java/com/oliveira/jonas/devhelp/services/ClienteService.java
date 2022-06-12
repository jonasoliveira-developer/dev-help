package com.oliveira.jonas.devhelp.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oliveira.jonas.devhelp.domain.Pessoa;
import com.oliveira.jonas.devhelp.domain.Cliente;
import com.oliveira.jonas.devhelp.domain.dtos.ClienteDTO;
import com.oliveira.jonas.devhelp.repositories.PessoaRepository;
import com.oliveira.jonas.devhelp.repositories.ClienteRepository;
import com.oliveira.jonas.devhelp.services.exceptions.DataIntegrationViolationException;
import com.oliveira.jonas.devhelp.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! id: " + id));
	}

	public List<Cliente> findAll() {

		return repository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		validaPorCpfEEmail(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return repository.save(newObj);
	}

	public Cliente update(Integer id, @Valid ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		validaPorCpfEEmail(objDTO);
		oldObj = new Cliente(objDTO);
		return repository.save(oldObj);

	}

	public void delete(Integer id) {

		Cliente obj = findById(id);
		if(obj.getChamados().size() > 0) {
			throw new DataIntegrationViolationException("Cliente possui ordens de serviço e não pode ser deletado!");	
		}
		repository.deleteById(id);
	}

	private void validaPorCpfEEmail(ClienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrationViolationException("Cpf Já cadastrado no sistema!!");
		}
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrationViolationException("E-mail já cadastrado no sistema");
		}
	}

}
