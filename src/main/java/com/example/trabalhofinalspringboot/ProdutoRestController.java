package com.example.trabalhofinalspringboot;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/produtos")
public class ProdutoRestController {
	
	@Autowired
	ProdutoRepository produtoRepository;
	
	@PostConstruct
	public void init() {
		produtoRepository.save(
			new Produto(1l, "Moto G6 Play", 
			"Smartphone Motorola Moto G6 Play Dual Chip Android Oreo - 8.0 Tela 5.7\" Octa-Core 1.4 GHz 32GB 4G Câmera 13MP - Índigo", 
			"Motorola", 899.10));
		produtoRepository.save(
			new Produto(2l, "Galaxy J6", 
			"Smartphone Samsung Galaxy J6 32GB Dual Chip Android 8.0 Tela 5.6\" Octa-Core 1.6GHz 4G Câmera 13MP com TV - Preto", 
			"Samsung", 799.90));
		produtoRepository.save(
			new Produto(3l, "Galaxy J4", 
			"Smartphone Samsung Galaxy J4 32GB Dual Chip Android 8.0 Tela 5.5\" Quad-Core 1.4GHz 4G Câmera 13MP - Preto", 
			"Samsung", 699.99));
		produtoRepository.save(
			new Produto(4l, "Moto G6 Plus", 
			"Smartphone Motorola Moto G6 Plus Dual Chip Android Oreo - 8.0 Tela 5.9\" Octa-Core 2.2 GHz 64GB 4G Câmera 12 + 5MP (Dual Traseira) - Índigo", 
			"Motorola", 1554.44));
		produtoRepository.save(
			new Produto(5l, "iPhone 8 Plus", 
			"iPhone 8 Plus Prata 64GB Tela 5.5\" IOS 11 4G Wi-Fi Câmera 12MP - Apple", 
			"Apple", 4599.99));
	}
	
	@GetMapping
	public List<Produto> getAll() {
		return produtoRepository.findAll();
	}
	
	@GetMapping(value="/{id}")
	public Produto get(@PathVariable Long id) {
		return produtoRepository.findOne(id);
	}
	
	@GetMapping("/nome/{nome}")
	public List<Produto> findByNome(@PathVariable String nome) {
		return produtoRepository.findByNomeContaining(nome);
	}
	
	@GetMapping("/marca/{marca}")
	public List<Produto> findByMarca(@PathVariable String marca) {
		return produtoRepository.findByMarcaContaining(marca);
	}
}
