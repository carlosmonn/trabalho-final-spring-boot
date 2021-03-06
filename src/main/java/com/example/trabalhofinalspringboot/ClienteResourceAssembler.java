package com.example.trabalhofinalspringboot;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class ClienteResourceAssembler extends ResourceAssemblerSupport<Cliente, ClienteResource> {

	public ClienteResourceAssembler() {
		super(Cliente.class, ClienteResource.class);
	}
	
	@Override
	public ClienteResource toResource(Cliente cliente) {
		return new ClienteResource(cliente, linkTo(methodOn(ClienteRestController.class).get(cliente.getId())).withSelfRel());
	}
	
	@Override
	protected ClienteResource instantiateResource(Cliente cliente) {
		return new ClienteResource(cliente);
	}
}
