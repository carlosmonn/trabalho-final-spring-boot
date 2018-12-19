package com.example.trabalhofinalspringboot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/clientescontroller")
public class ClienteRestController {
	
	@Autowired
	ClienteRepository repository;
	
	ClienteResourceAssembler assembler = new ClienteResourceAssembler();
	
	@PostConstruct
	public void init() throws ParseException {
		
		Cliente cliente1 = new Cliente(1l, "Carlos", 
				"carlos@unidavi.edu.br", "111.111.111-11", 
				new SimpleDateFormat("yyyy-MM-dd").parse("1992-12-25"), 
				null);
		
		cliente1.setEndereco(new Endereco(1l, "Rua 1", "Cidade 1", "SC", "00000-000", cliente1));
		repository.save(cliente1);
		
		Cliente cliente2 = new Cliente(2l, "Gerson", 
				"gerson@unidavi.edu.br", "222.222.222-22", 
				new SimpleDateFormat("yyyy-MM-dd").parse("1980-10-20"), 
				null);
		
		cliente2.setEndereco(new Endereco(2l, "Rua 2", "Cidade 2", "SC", "00000-000", cliente2));
		repository.save(cliente2);
		
		Cliente cliente3 = new Cliente(3l, "romario", 
				"romario@unidavi.edu.br", "333.333.333-33", 
				new SimpleDateFormat("yyyy-MM-dd").parse("1993-06-10"), 
				null);
		
		cliente3.setEndereco(new Endereco(3l, "Rua 3", "Cidade 3", "SC", "00000-000", cliente3));
		repository.save(cliente3);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ClienteResource> get(@PathVariable Long id) {
		Cliente cliente = repository.findOne(id);
		
		if (cliente != null) {
			return new ResponseEntity<>(assembler.toResource(cliente), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	/*
	@GetMapping
	public ResponseEntity<List<ClienteResource>> getAll() {
		return new ResponseEntity<>(assembler.toResources(repository.findAll()), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ClienteResource> add(@RequestBody Cliente cliente) {
		cliente = repository.save(cliente);
		
		if (cliente != null) {
			return new ResponseEntity<>(assembler.toResource(cliente), HttpStatus.OK);					
		} else {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ClienteResource> update(@PathVariable Long id, @RequestBody Cliente cliente) {
		if (cliente != null) {
			cliente.setId(id);
			cliente = repository.save(cliente);
			
			return new ResponseEntity<>(assembler.toResource(cliente), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ClienteResource> delete(@PathVariable Long id) {
		Cliente cliente = repository.findOne(id);
		
		if (cliente != null) {
			repository.delete(cliente);
			
			return new ResponseEntity<>(assembler.toResource(cliente), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}*/
	
	/*@GetMapping("/endereco/{endereco}")
	public ResponseEntity<List<ClienteResource>> findByEndereco(@PathVariable String endereco) {
		return new ResponseEntity<>(assembler.toResources(repository.findByEnderecoContaining(endereco)), HttpStatus.OK);
	}*/
}
