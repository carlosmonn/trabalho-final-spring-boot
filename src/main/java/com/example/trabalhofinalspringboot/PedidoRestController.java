package com.example.trabalhofinalspringboot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/pedidoscontroller")
public class PedidoRestController {

	@Autowired
	PedidoRepository repository;
	
	@PostConstruct
	public void init() throws ParseException {
		
		/*Cliente cliente1 = new Cliente();
		cliente1 = repositoryCliente.findOne(1l);
		
		Pedido pedido1 = new Pedido(1l, 1l, 100.00, new Date(), null, cliente1);
		
		List<Item> itens1 = new ArrayList<>();
		itens1.add(new Item(1l, 10, 4.00, pedido1));
		itens1.add(new Item(2l, 10, 6.00, pedido1));
		
		pedido1.setItens(itens1);
		repository.save(pedido1);
		
		Pedido pedido2 = new Pedido(2l, 2l, 200.00, new Date(), null, cliente1);
		
		List<Item> itens2 = new ArrayList<>();
		itens2.add(new Item(3l, 10, 10.00, pedido2));
		itens2.add(new Item(4l, 10, 10.00, pedido2));
		
		pedido2.setItens(itens2);
		repository.save(pedido2);
		
		Pedido pedido3 = new Pedido(3l, 3l, 300.00, new Date(), null, cliente1);
		
		List<Item> itens3 = new ArrayList<>();
		itens3.add(new Item(5l, 15, 20.00, pedido3));
		
		pedido3.setItens(itens3);
		repository.save(pedido3);*/
	}
}
