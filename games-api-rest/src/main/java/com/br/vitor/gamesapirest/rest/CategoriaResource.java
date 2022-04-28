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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.br.vitor.gamesapirest.form.CategoriaForm;
import com.br.vitor.gamesapirest.modelo.Categoria;
import com.br.vitor.gamesapirest.repository.CategoriaRepository;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaResource {

	@Autowired
	CategoriaRepository categoriaRepository;
	
	@GetMapping("")
	public List<Categoria> listar(){
		return categoriaRepository.findAll();
	}
	
	@PostMapping("")
	public Categoria cadastrarCategoria(@RequestBody @Valid CategoriaForm categoriaForm){
		Categoria cat = categoriaForm.converter();
		Categoria categoria = categoriaRepository.save(cat);
		return categoria;
	}
	
	@GetMapping("{id}")
	public Categoria detalhar(@PathVariable Long id){
		Categoria categoria = categoriaRepository.findById(id).get();
		return categoria;
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<?> deletar(@PathVariable Long id){
		
		Optional<Categoria> optional = categoriaRepository.findById(id);
		
		if(optional.isPresent()) {
			categoriaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}else {
			return ResponseEntity.notFound().build();	
		}
	}
}
