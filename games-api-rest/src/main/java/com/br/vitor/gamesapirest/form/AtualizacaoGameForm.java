package com.br.vitor.gamesapirest.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.br.vitor.gamesapirest.modelo.Categoria;
import com.br.vitor.gamesapirest.modelo.Game;
import com.br.vitor.gamesapirest.repository.CategoriaRepository;
import com.br.vitor.gamesapirest.repository.GameRepository;

public class AtualizacaoGameForm {

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
	
	public Game atualizar(Long id, GameRepository gameRepository, CategoriaRepository categoriaRepository) {
		
		Categoria categoria = categoriaRepository.findByNome(nomeCategoria);
		Game game = gameRepository.findById(id).get();
		game.setId(id);
		game.setNome(this.nome);
		game.setDescricao(this.descricao);
		game.setPreco(this.preco);
		game.setCategoria(categoria);

		return game;
	}
}
