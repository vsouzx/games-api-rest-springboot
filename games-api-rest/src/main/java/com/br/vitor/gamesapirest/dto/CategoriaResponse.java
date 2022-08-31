package com.br.vitor.gamesapirest.dto;

import javax.validation.constraints.NotBlank;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class CategoriaResponse {

	private String nome;
}
