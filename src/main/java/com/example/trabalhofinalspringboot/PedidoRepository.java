package com.example.trabalhofinalspringboot;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(path = "pedidos")
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	@RestResource(path = "/searchDataCriacao")
	@Query(value = "SELECT * FROM pedido WHERE FORMATDATETIME(DATA_CRIACAO, 'yyyy-MM-dd') = :datacriacao", nativeQuery = true)
	List<Pedido> findByDataCriacao(@Param("datacriacao") String dataCriacao);
}
