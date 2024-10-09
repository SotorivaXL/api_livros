package br.edu.famper.api_livros.repository;
import br.edu.famper.api_livros.model.Livros;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivrosRepository extends JpaRepository<Livros, Long> {}
