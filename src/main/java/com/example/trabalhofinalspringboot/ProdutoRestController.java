package com.example.trabalhofinalspringboot;

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
@RequestMapping(value="/produtos")
public class ProdutoRestController {
	
	@Autowired
	ProdutoRepository repository;
	
	ProdutoResourceAssembler assembler = new ProdutoResourceAssembler();
	
	@PostConstruct
	public void init() {
		repository.save(
			new Produto(1l, "Moto G6 Play", 
				"Smartphone Motorola Moto G6 Play Dual Chip Android Oreo - 8.0 Tela 5.7\" Octa-Core 1.4 GHz 32GB 4G Câmera 13MP - Índigo", 
				"Motorola", 899.10));
		repository.save(
			new Produto(2l, "Galaxy J6", 
				"Smartphone Samsung Galaxy J6 32GB Dual Chip Android 8.0 Tela 5.6\" Octa-Core 1.6GHz 4G Câmera 13MP com TV - Preto", 
				"Samsung", 799.90));
		repository.save(
			new Produto(3l, "Galaxy J4", 
				"Smartphone Samsung Galaxy J4 32GB Dual Chip Android 8.0 Tela 5.5\" Quad-Core 1.4GHz 4G Câmera 13MP - Preto", 
				"Samsung", 699.99));
		repository.save(
			new Produto(4l, "Moto G6 Plus", 
				"Smartphone Motorola Moto G6 Plus Dual Chip Android Oreo - 8.0 Tela 5.9\" Octa-Core 2.2 GHz 64GB 4G Câmera 12 + 5MP (Dual Traseira) - Índigo", 
				"Motorola", 1554.44));
		repository.save(
			new Produto(5l, "iPhone 8 Plus", 
				"iPhone 8 Plus Prata 64GB Tela 5.5\" IOS 11 4G Wi-Fi Câmera 12MP - Apple", 
				"Apple", 4599.99));
	}
	
	@GetMapping
	public ResponseEntity<List<ProdutoResource>> getAll() {
		return new ResponseEntity<>(assembler.toResources(repository.findAll()), HttpStatus.OK);
	}
	
	@GetMapping(value="/{id}")
	public ResponseEntity<ProdutoResource> get(@PathVariable Long id) {
		Produto produto = repository.findOne(id);
		
		if (produto != null) {
			return new ResponseEntity<>(assembler.toResource(produto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping
	public ResponseEntity<ProdutoResource> add(@RequestBody Produto produto) {
		produto = repository.save(produto);
		
		if (produto != null) {
			return new ResponseEntity<>(assembler.toResource(produto), HttpStatus.OK);					
		} else {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoResource> update(@PathVariable Long id, @RequestBody Produto produto) {
		if (produto != null) {
			produto.setId(id);
			produto = repository.save(produto);
			
			return new ResponseEntity<>(assembler.toResource(produto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<ProdutoResource> delete(@PathVariable Long id) {
		Produto produto = repository.findOne(id);
		
		if (produto != null) {
			repository.delete(produto);
			
			return new ResponseEntity<>(assembler.toResource(produto), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
	}
	
	@GetMapping("/nome/{nome}")
	public ResponseEntity<List<ProdutoResource>> findByNome(@PathVariable String nome) {
		return new ResponseEntity<>(assembler.toResources(repository.findByNomeContaining(nome)), HttpStatus.OK);
	}
	
	@GetMapping("/marca/{marca}")
	public ResponseEntity<List<ProdutoResource>> findByMarca(@PathVariable String marca) {
		return new ResponseEntity<>(assembler.toResources(repository.findByMarcaContaining(marca)), HttpStatus.OK);
	}
}
