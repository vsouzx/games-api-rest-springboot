package com.br.vitor.gamesapirest.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.br.vitor.gamesapirest.modelo.Categoria;

public class CategoriaForm {

	@NotNull @NotBlank
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public Categoria converter() {
		return new Categoria(nome);
	}
	
	
}
