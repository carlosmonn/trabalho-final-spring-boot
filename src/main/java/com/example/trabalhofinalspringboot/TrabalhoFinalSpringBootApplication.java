package com.example.trabalhofinalspringboot;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TrabalhoFinalSpringBootApplication {

	@Autowired
	ProdutoRepository repProduto;
	
	@Autowired
	ClienteRepository repCliente;
	
	@Autowired
	PedidoRepository repPedido;
	
	@PostConstruct
	public void init() throws ParseException {
		Produto produto1 = new Produto(1l, "Moto G6 Play", 
				"Smartphone Motorola Moto G6 Play Dual Chip Android Oreo - 8.0 Tela 5.7\" Octa-Core 1.4 GHz 32GB 4G Câmera 13MP - Índigo", 
				"Motorola", 899.10, null);
		repProduto.save(produto1);
		
		Produto produto2 = new Produto(2l, "Galaxy J6", 
				"Smartphone Samsung Galaxy J6 32GB Dual Chip Android 8.0 Tela 5.6\" Octa-Core 1.6GHz 4G Câmera 13MP com TV - Preto", 
				"Samsung", 799.90, null);
		repProduto.save(produto2);
		
		Produto produto3 = new Produto(3l, "Galaxy J4", 
				"Smartphone Samsung Galaxy J4 32GB Dual Chip Android 8.0 Tela 5.5\" Quad-Core 1.4GHz 4G Câmera 13MP - Preto", 
				"Samsung", 699.99, null);
		repProduto.save(produto3);
		
		Produto produto4 = new Produto(4l, "Moto G6 Plus", 
				"Smartphone Motorola Moto G6 Plus Dual Chip Android Oreo - 8.0 Tela 5.9\" Octa-Core 2.2 GHz 64GB 4G Câmera 12 + 5MP (Dual Traseira) - Índigo", 
				"Motorola", 1554.44, null);
		repProduto.save(produto4);
		
		Produto produto5 = new Produto(5l, "iPhone 8 Plus", 
				"iPhone 8 Plus Prata 64GB Tela 5.5\" IOS 11 4G Wi-Fi Câmera 12MP - Apple", 
				"Apple", 4599.99, null);
		repProduto.save(produto5);
		
		Cliente cliente1 = new Cliente(1l, "Carlos", 
				"carlos@unidavi.edu.br", "111.111.111-11", 
				new SimpleDateFormat("yyyy-MM-dd").parse("1992-12-25"), 
				null, null);
		
		cliente1.setEndereco(new Endereco(1l, "Rua 1", "Cidade 1", "SC", "00000-000", cliente1));
		repCliente.save(cliente1);
		
		Cliente cliente2 = new Cliente(2l, "Gerson", 
				"gerson@unidavi.edu.br", "222.222.222-22", 
				new SimpleDateFormat("yyyy-MM-dd").parse("1980-10-20"), 
				null, null);
		
		cliente2.setEndereco(new Endereco(2l, "Rua 2", "Cidade 2", "SC", "00000-000", cliente2));
		repCliente.save(cliente2);
		
		Cliente cliente3 = new Cliente(3l, "romario", 
				"romario@unidavi.edu.br", "333.333.333-33", 
				new SimpleDateFormat("yyyy-MM-dd").parse("1993-06-10"), 
				null, null);
		
		cliente3.setEndereco(new Endereco(3l, "Rua 3", "Cidade 3", "SC", "00000-000", cliente3));
		repCliente.save(cliente3);
		
		Pedido pedido1 = new Pedido(1l, 1l, 100.00, new Date(), null, cliente1);
		
		List<Item> itens1 = new ArrayList<>();
		itens1.add(new Item(1l, 10, 4.00, pedido1, produto1));
		itens1.add(new Item(2l, 10, 6.00, pedido1, produto2));
		
		pedido1.setItens(itens1);
		repPedido.save(pedido1);
		
		Pedido pedido2 = new Pedido(2l, 2l, 200.00, new Date(), null, cliente2);
		
		List<Item> itens2 = new ArrayList<>();
		itens2.add(new Item(3l, 10, 10.00, pedido2, produto3));
		itens2.add(new Item(4l, 10, 10.00, pedido2, produto4));
		
		pedido2.setItens(itens2);
		repPedido.save(pedido2);
		
		Pedido pedido3 = new Pedido(3l, 3l, 300.00, new Date(), null, cliente1);
		
		List<Item> itens3 = new ArrayList<>();
		itens3.add(new Item(5l, 15, 20.00, pedido3, produto2));
		
		pedido3.setItens(itens3);
		repPedido.save(pedido3);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(TrabalhoFinalSpringBootApplication.class, args);
	}
}
