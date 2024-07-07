package com.aluracursos.challengeliteralura.repository;

import com.aluracursos.challengeliteralura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    List<Autor> findByFechaDeFallecimientoGreaterThan(Integer año);
}
