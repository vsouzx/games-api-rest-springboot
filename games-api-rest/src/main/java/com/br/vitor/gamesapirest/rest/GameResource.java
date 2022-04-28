package com.br.vitor.gamesapirest.rest;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.vitor.gamesapirest.dto.GameDto;
import com.br.vitor.gamesapirest.form.AtualizacaoGameForm;
import com.br.vitor.gamesapirest.form.GameForm;
import com.br.vitor.gamesapirest.modelo.Game;
import com.br.vitor.gamesapirest.repository.CategoriaRepository;
import com.br.vitor.gamesapirest.repository.GameRepository;

@RestController
@RequestMapping(value = "games")
public class GameResource {
	
	@Autowired
	GameRepository gameRepository;
	
	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping("")
	public List<GameDto> listar(){
		List<Game> games = gameRepository.findAll();
		return GameDto.converter(games);
	}
	
	@PostMapping("")
	public GameDto cadastrar(@RequestBody @Valid GameForm gameForm){
		Game game = gameForm.converter(categoriaRepository);
		Game newGame = gameRepository.save(game);
		return new GameDto(newGame);
	}
	
	@GetMapping("{id}")
	public Game detalhar(@PathVariable Long id){
		Game game = gameRepository.findById(id).get();
		return game;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		
		Optional<Game> optional = gameRepository.findById(id);
		
		if(optional.isPresent()) {
			gameRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();	
		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Game> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizacaoGameForm form) {
		
		Optional<Game> optional = gameRepository.findById(id);
		
		if(optional.isPresent()) {
			Game game = form.atualizar(id, gameRepository, categoriaRepository);
			gameRepository.save(game);
			return ResponseEntity.ok(game);
		}
		
		return ResponseEntity.notFound().build();	
		 
	}
}
