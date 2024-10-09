package br.edu.famper.api_livros.controller;
import br.edu.famper.api_livros.model.Livros;
import br.edu.famper.api_livros.services.LivrosServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("api/livros")
public class LivrosController {

    @Autowired
    private LivrosServices livrosServices;

    @GetMapping
    public ResponseEntity<List<Livros>> findAll(){
        return livrosServices.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livros> findById(@PathVariable Long id){
        return livrosServices.findById(id);
    }

    @PostMapping
    public ResponseEntity<Livros> create(@RequestBody Livros livros){
        return livrosServices.save(livros);
    }

    @PutMapping
    public ResponseEntity<Livros> update(@RequestBody Livros livros){
        return livrosServices.update(livros);
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody Livros livros){
        livrosServices.deleteById(livros.getId());
        return ResponseEntity.noContent().build();
    }

}