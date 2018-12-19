package com.example.trabalhofinalspringboot;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ProdutoRepositoryTest {
	
	@Autowired
	ProdutoRepository repository;
	
	public Produto salvarProdutoTeste() {
		Produto produto = new Produto(
				6l, "Produto teste", 
				"Descrição do produto teste", 
				"Marca teste", 123.45);
		
		return repository.save(produto);
	}
	
	@Test
	public void testSaveProduto() throws Exception {
		Produto produto = salvarProdutoTeste();
		
		assertNotNull(produto);
		assertTrue(produto.getId() != null);
	}
	
	@Test
	public void testDeleteProduto() throws Exception {		
		Produto produto = salvarProdutoTeste();
		assertNotNull(produto);
		
        repository.delete(produto);
        produto = repository.findOne(produto.getId());

        assertNull(produto);
	}
	
	@Test
	public void testFindByNomeContaining() throws Exception {
		testSaveProduto();
		
		List<Produto> produtos = repository.findByNomeContaining("Produto teste");
		
		assertNotNull(produtos);
        assertFalse(produtos.isEmpty());
        assertTrue(produtos.get(0).getNome().equals("Produto teste"));
	}
	
	@Test
	public void testFindByMarcaContaining() throws Exception {
		testSaveProduto();
		
		List<Produto> produtos = repository.findByMarcaContaining("Marca teste");
		
		assertNotNull(produtos);
        assertFalse(produtos.isEmpty());
        assertTrue(produtos.get(0).getNome().equals("Produto teste"));
	}
}
