package br.edu.famper.api_livros.services;
import br.edu.famper.api_livros.model.Livros;
import br.edu.famper.api_livros.repository.LivrosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivrosServices {

    @Autowired
    private LivrosRepository livrosRepository;

    public ResponseEntity<List<Livros>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(livrosRepository.findAll());
    }

    public ResponseEntity<Livros> findById(Long id){
        return livrosRepository.findById(id).map(livros -> ResponseEntity.status(HttpStatus.OK).body(livros))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    public ResponseEntity<Livros> save(Livros livros){
        return ResponseEntity.status(HttpStatus.CREATED).body(livrosRepository.save(livros));

    }


    public ResponseEntity<Livros> update(Livros livros){

        Livros livrosSaved = livrosRepository.findById(livros.getId())
                .orElseThrow(()-> new RuntimeException("Livro não encontrado!"));


        livrosSaved.setTituloLivro(livros.getTituloLivro());
        livrosSaved.setAutorLivro(livros.getAutorLivro());
        livrosSaved.setAnoPublicacaoLivro(livros.getAnoPublicacaoLivro());
        livrosSaved.setPrecoLivro(livros.getPrecoLivro());

        return ResponseEntity.status(HttpStatus.OK).body(livrosRepository.save(livrosSaved));
    }

    public void deleteById(Long id){
        livrosRepository.deleteById(id);
    }

}

