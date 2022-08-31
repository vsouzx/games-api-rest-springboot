package com.br.vitor.gamesapirest.controller;

import com.br.vitor.gamesapirest.service.GameService;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.vitor.gamesapirest.dto.GameResponse;
import com.br.vitor.gamesapirest.dto.GameRequest;
import com.br.vitor.gamesapirest.modelo.Game;
import com.br.vitor.gamesapirest.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "/games")
public class GameController {

	@Autowired
	private GameService gameService;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GameResponse>> listar() {
		return ResponseEntity.ok(gameService.listar());
	}

	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GameResponse> cadastrar(@RequestBody @Valid GameRequest gameRequest) throws Exception {
		return ResponseEntity.ok(gameService.cadastrar(gameRequest));
	}

	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Game> detalhar(@PathVariable("id") Long id) throws Exception {
		return ResponseEntity.ok(gameService.detalhar(id));
	}

	@DeleteMapping(value = "/{id}")
	public void deletar(@PathVariable Long id) throws Exception {
		gameService.deletar(id);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<GameResponse> atualizar(@PathVariable Long id, @RequestBody @Valid GameRequest request) throws Exception {
		return ResponseEntity.ok(gameService.atualizar(id, request));
	}
}
