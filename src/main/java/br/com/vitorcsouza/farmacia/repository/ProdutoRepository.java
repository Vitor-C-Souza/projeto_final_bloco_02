package br.com.vitorcsouza.farmacia.repository;

import br.com.vitorcsouza.farmacia.model.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    Page<Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome, Pageable pageable);
}
