package com.example.trabalhofinalspringboot;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Endereco {

	@Id @GeneratedValue
	Long id;
	String rua;
	String cidade;
	String estado;
	String cep;
	
	@OneToOne
	@JoinColumn(name = "cliente_id", referencedColumnName = "id", nullable = false)
	Cliente cliente;
}
