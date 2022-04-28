package com.br.vitor.gamesapirest.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.br.vitor.gamesapirest.modelo.Categoria;
import com.br.vitor.gamesapirest.modelo.Game;
import com.br.vitor.gamesapirest.repository.CategoriaRepository;

public class GameForm {
	
	@NotNull @NotBlank
	private String nome;
	
	@NotNull @NotBlank
	private String descricao;
	
	@NotNull
	private double preco;
	
	@NotNull @NotBlank
	private String nomeCategoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getNomeCategoria() {
		return nomeCategoria;
	}

	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}

	public Game converter(CategoriaRepository categoriaRepository) {
		Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
		
		return new Game(nome, descricao, preco, categoria);
	}
	
	
}
