package com.example.trabalhofinalspringboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "produtos")
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
	
	@RestResource(path = "/searchNome")
	List<Produto> findByNomeContaining(@Param("nome") String nome);
	
	@RestResource(path = "/searchMarca")
	List<Produto> findByMarcaContaining(@Param("marca") String marca);
}
