package br.edu.famper.api_livros.model;
import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Entity
@Table(name = "livros")
@Data
public class Livros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "titulo", length = 100)
    private String tituloLivro;

    @NotNull
    @Column(name = "autor", length = 100)
    private String autorLivro;

    @NotNull
    @Column(name = "ano_publicacao", length = 4)
    private Number anoPublicacaoLivro;

    @NotNull
    @Column(name = "preco")
    private Double precoLivro;

}
