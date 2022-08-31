package com.br.vitor.gamesapirest.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.br.vitor.gamesapirest.modelo.Game;
import lombok.*;

@Builder
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class GameResponse {

	private Long id;
	private String nome;
	private String descricao;
	private double preco;
}
