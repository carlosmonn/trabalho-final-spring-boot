package com.example.trabalhofinalspringboot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "itens")
public interface ItemRepository extends JpaRepository<Item, Long> {

}
