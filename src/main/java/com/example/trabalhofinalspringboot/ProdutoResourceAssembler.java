package com.example.trabalhofinalspringboot;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

public class ProdutoResourceAssembler extends ResourceAssemblerSupport<Produto, ProdutoResource> {

	public ProdutoResourceAssembler() {
		super(Produto.class, ProdutoResource.class);
	}

	@Override
	public ProdutoResource toResource(Produto produto) {
		return new ProdutoResource(produto, linkTo(methodOn(ProdutoRestController.class).get(produto.getId())).withSelfRel());
	}
	
	@Override
	protected ProdutoResource instantiateResource(Produto produto) {
		return new ProdutoResource(produto);
	}

}
