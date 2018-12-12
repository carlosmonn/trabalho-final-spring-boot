package com.example.trabalhofinalspringboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	List<Produto> findByNomeContaining(String nome);
	
	List<Produto> findByMarcaContaining(String marca);
}
