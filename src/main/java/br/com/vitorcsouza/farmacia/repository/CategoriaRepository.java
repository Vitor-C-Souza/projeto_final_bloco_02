package br.com.vitorcsouza.farmacia.repository;

import br.com.vitorcsouza.farmacia.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    Page<Categoria> findAllByNomeContainingIgnoreCase(@Param("nome") String nome, Pageable pageable);
}
