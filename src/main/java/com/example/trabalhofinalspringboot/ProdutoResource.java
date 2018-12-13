package com.example.trabalhofinalspringboot;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;

public class ProdutoResource extends Resource<Produto> {

	public ProdutoResource(Produto produto, Link... links) {
		super(produto, links);
	}
}
