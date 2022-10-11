package com.br.vitor.gamesapirest.service;

import com.br.vitor.gamesapirest.dto.GameRequest;
import com.br.vitor.gamesapirest.dto.GameResponse;
import com.br.vitor.gamesapirest.modelo.Game;
import com.br.vitor.gamesapirest.repository.CategoriaRepository;
import com.br.vitor.gamesapirest.repository.GameRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private final GameRepository gameRepository;

    private final CategoriaRepository categoriaRepository;

    public GameService(GameRepository gameRepository, CategoriaRepository categoriaRepository) {
        this.gameRepository = gameRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public List<GameResponse> listar() {
        List<Game> games = gameRepository.findAll();

        List<GameResponse> response = new ArrayList<GameResponse>();

        games.stream().forEach(game -> {
            response.add(GameResponse.builder()
                                     .id(game.getId())
                                     .nome(game.getNome())
                                     .descricao(game.getDescricao())
                                     .preco(game.getPreco())
                                     .build());
        });
        return response;
    }

    public GameResponse cadastrar(GameRequest gameRequest) throws Exception {

        if ((gameRepository.findByNome(gameRequest.getNome()) == null)) {
            gameRepository.save(Game.builder()
                                    .descricao(gameRequest.getDescricao())
                                    .nome(gameRequest.getNome())
                                    .preco(gameRequest.getPreco())
                                    .categoria(categoriaRepository.findByNome(gameRequest.getNomeCategoria()))
                                    .build());
            return GameResponse.builder()
                               .preco(gameRequest.getPreco())
                               .descricao(gameRequest.getDescricao())
                               .nome(gameRequest.getNome())
                               .build();
        } else {
            throw new Exception("Esse game já existe");
        }
    }

    public Game detalhar(Long id) throws Exception {
        Optional<Game> possivelGame = gameRepository.findById(id);

        if(possivelGame.isPresent()){
            return Game.builder()
                    .id(possivelGame.get().getId())
                    .nome(possivelGame.get().getNome())
                    .descricao(possivelGame.get().getDescricao())
                    .preco(possivelGame.get().getPreco())
                    .categoria(possivelGame.get().getCategoria())
                    .build();
        }else {
            throw new Exception("Esse game não existe");
        }
    }

    public void deletar(Long id) throws Exception {
        Optional<Game> optional = gameRepository.findById(id);
        if(optional.isPresent()) {
            gameRepository.deleteById(id);
        }else{
            throw new Exception("Esse game não existe");
        }
    }

    public GameResponse atualizar(Long id, GameRequest request) throws Exception {
        Optional<Game> optional = gameRepository.findById(id);

        if(optional.isPresent()) {
            gameRepository.save(Game.builder()
                    .id(id)
                    .nome(request.getNome())
                    .categoria(categoriaRepository.findByNome(request.getNomeCategoria()))
                    .preco(request.getPreco())
                    .descricao(request.getDescricao())
                    .build());

            return GameResponse.builder()
                    .id(id)
                    .nome(request.getNome())
                    .preco(request.getPreco())
                    .descricao(request.getDescricao())
                    .build();
        }else{
            throw new Exception("Esse game não existe");
    }
    }
}