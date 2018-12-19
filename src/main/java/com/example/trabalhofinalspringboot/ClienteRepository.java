package com.example.trabalhofinalspringboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "clientes")
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
	
	@RestResource(path = "/searchEndereco")
	@Query(value = 
	    "SELECT * " + 
	    "  FROM cliente c " +
	    "  JOIN endereco e " +
	    "    ON e.cliente_id = c.id" +
	    " WHERE e.rua LIKE %:endereco%" + 
	    "    OR e.cidade LIKE %:endereco%" + 
	    "    OR e.estado LIKE %:endereco%", 
	    nativeQuery = true)
	List<Cliente> findByEnderecoContaining(@Param("endereco") String endereco);
	
}
