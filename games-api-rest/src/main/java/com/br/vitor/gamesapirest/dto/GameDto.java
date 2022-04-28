package com.br.vitor.gamesapirest.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.br.vitor.gamesapirest.modelo.Game;

public class GameDto {

	private Long id;
	
	

	@NotNull @NotBlank
	private String nome;
	
	@NotNull @NotBlank
	private String descricao;
	
	@NotNull
	private double preco;

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
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public GameDto(Game newGame) {
		this.id = newGame.getId();
		this.nome = newGame.getNome();
		this.descricao = newGame.getDescricao();
		this.preco = newGame.getPreco();
	}
	
	public static List<GameDto> converter(List<Game> games) {
		
		return games.stream().map(GameDto::new).collect(Collectors.toList());
	}
}
