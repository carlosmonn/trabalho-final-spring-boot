package com.example.trabalhofinalspringboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/enderecos")
public class EnderecoRestController {

	@Autowired
	EnderecoRepository repository;
	
	EnderecoResourceAssembler assembler = new EnderecoResourceAssembler();
	
	@GetMapping
	public ResponseEntity<List<EnderecoResource>> getAll() {
		return new ResponseEntity<>(assembler.toResources(repository.findAll()), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<EnderecoResource> get(@PathVariable Long id) {
		Endereco endereco = repository.findOne(id);
		
		if (endereco != null) {
			return new ResponseEntity<>(assembler.toResource(endereco), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
}
