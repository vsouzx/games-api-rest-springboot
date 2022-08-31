package com.br.vitor.gamesapirest.service;

import com.br.vitor.gamesapirest.dto.CategoriaRequest;
import com.br.vitor.gamesapirest.dto.CategoriaResponse;
import com.br.vitor.gamesapirest.modelo.Categoria;
import com.br.vitor.gamesapirest.repository.CategoriaRepository;
import com.br.vitor.gamesapirest.repository.GameRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<CategoriaResponse> listar(){
        List<Categoria> categorias = categoriaRepository.findAll();

        List<CategoriaResponse> response = new ArrayList<CategoriaResponse>();

        categorias.stream().forEach(categoria -> {
            response.add(CategoriaResponse.builder()
                    .nome(categoria.getNome())
                    .build());
        });
        return response;
    }

    public CategoriaResponse cadastrar(CategoriaRequest request) throws Exception {
        if((categoriaRepository.findByNome(request.getNome())) == null){
            categoriaRepository.save(Categoria.builder().nome(request.getNome()).build());
            return CategoriaResponse.builder()
                    .nome(request.getNome())
                    .build();
        }else{
            throw new Exception("Essa categoria já existe!");
        }
    }

    public Categoria detalhar(Long id) throws Exception {
        Optional<Categoria> possivelCategoria = categoriaRepository.findById(id);

        if(possivelCategoria.isPresent()){
            return Categoria.builder()
                    .id(id)
                    .nome(possivelCategoria.get().getNome())
                    .build();
        }else{
            throw new Exception("Essa categoria não existe!");
        }
    }

    public void deletar(Long id) throws Exception {
        Optional<Categoria> optional = categoriaRepository.findById(id);

        if(optional.isPresent()) {
            categoriaRepository.deleteById(id);
        }else {
            throw new Exception("Essa categoria não existe!");
        }
    }

    public CategoriaResponse atualizar(Long id, CategoriaRequest request) throws Exception {
        Optional<Categoria> optional = categoriaRepository.findById(id);

        if(optional.isPresent()) {
            categoriaRepository.save(Categoria.builder().nome(request.getNome()).build());
            return CategoriaResponse.builder()
                    .nome(request.getNome())
                    .build();
        }else {
            throw new Exception("Essa categoria não existe!");
        }
    }
}
