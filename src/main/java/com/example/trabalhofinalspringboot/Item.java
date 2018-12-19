package com.example.trabalhofinalspringboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Item {
	
	@Id @GeneratedValue
	Long id;
	Integer quantidade;
	double total;
	
	@ManyToOne
	Pedido pedido;
	
	@ManyToOne
	Produto produto;
}
