package com.aluracursos.challengeliteralura.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "libros")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @ManyToOne(cascade = CascadeType.PERSIST)
    private com.aluracursos.challengeliteralura.model.Autor autor;
    private String idioma;
    private Integer numeroDeDescargas;

    public Libro(com.aluracursos.challengeliteralura.model.DatosLibro libro) {
        this.titulo = libro.titulo();
        Optional<com.aluracursos.challengeliteralura.model.DatosAutor> autor = libro.autores().stream()
                .findFirst();
        if (autor.isPresent()) {
            this.autor = new com.aluracursos.challengeliteralura.model.Autor(autor.get());
        } else {
            System.out.println("No se ha podido encontrar el autor");
        }
        this.idioma = libro.idiomas().get(0);
        this.numeroDeDescargas = libro.numeroDeDescargas();
    }

    public void setAutor(com.aluracursos.challengeliteralura.model.Autor autor) {
        this.autor = autor;
    }

}
