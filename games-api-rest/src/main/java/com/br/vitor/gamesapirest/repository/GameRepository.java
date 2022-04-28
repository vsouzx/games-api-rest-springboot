package com.br.vitor.gamesapirest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.br.vitor.gamesapirest.modelo.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long>{
	
}
