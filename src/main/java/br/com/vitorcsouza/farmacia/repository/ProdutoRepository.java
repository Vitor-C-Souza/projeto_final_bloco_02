package br.com.vitorcsouza.farmacia.repository;

import br.com.vitorcsouza.farmacia.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    List<Produto> findAllByNomeContainingIgnoreCase(@Param("nome") String nome);
}
