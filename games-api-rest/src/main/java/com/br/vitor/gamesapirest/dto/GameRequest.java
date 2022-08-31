package com.br.vitor.gamesapirest.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.br.vitor.gamesapirest.modelo.Categoria;
import com.br.vitor.gamesapirest.modelo.Game;
import com.br.vitor.gamesapirest.repository.CategoriaRepository;
import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class GameRequest {
	
	@NotBlank
	private String nome;
	
	@NotBlank
	private String descricao;
	
	@NotNull
	private double preco;
	
	@NotBlank
	private String nomeCategoria;

}
