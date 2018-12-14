package com.example.trabalhofinalspringboot;

import java.util.Date;

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
public class Cliente {
	
	@Id @GeneratedValue
	Long id;
	String nome;
	String email;
	String cpf;
	Date dataNascimento;
}
