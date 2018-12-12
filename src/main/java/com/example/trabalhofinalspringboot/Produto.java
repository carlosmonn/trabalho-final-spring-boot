package com.example.trabalhofinalspringboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Produto {

	@Id @GeneratedValue
	Long id;
	String nome;
	String descricao;
	String marca;
	Double valor;
}
