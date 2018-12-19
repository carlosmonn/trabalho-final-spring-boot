package com.example.trabalhofinalspringboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "pedidos")
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
