package com.br.vitor.gamesapirest.controller;

import com.br.vitor.gamesapirest.dto.CategoriaResponse;
import com.br.vitor.gamesapirest.service.CategoriaService;
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

import com.br.vitor.gamesapirest.dto.CategoriaRequest;
import com.br.vitor.gamesapirest.modelo.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<CategoriaResponse>> listar(){
		return ResponseEntity.ok(categoriaService.listar());
	}
	
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaResponse> cadastrarCategoria(@RequestBody @Valid CategoriaRequest categoriaRequest) throws Exception {
		return ResponseEntity.ok(categoriaService.cadastrar(categoriaRequest));
	}
	
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Categoria> detalhar(@PathVariable Long id) throws Exception {
		return ResponseEntity.ok(categoriaService.detalhar(id));
	}

	@DeleteMapping(value = "{id}")
	public void deletar(@PathVariable Long id) throws Exception {
		categoriaService.deletar(id);
	}

	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CategoriaResponse> atualizar(@PathVariable Long id, @RequestBody @Valid CategoriaRequest request) throws Exception {
		return ResponseEntity.ok(categoriaService.atualizar(id, request));
	}
}
