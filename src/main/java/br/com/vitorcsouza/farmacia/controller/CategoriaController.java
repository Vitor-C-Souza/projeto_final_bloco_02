package br.com.vitorcsouza.farmacia.controller;

import br.com.vitorcsouza.farmacia.model.Categoria;
import br.com.vitorcsouza.farmacia.repository.CategoriaRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriaController {
    @Autowired
    private CategoriaRepository repository;

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody @Valid Categoria categoria, UriComponentsBuilder uri) {
        repository.save(categoria);
        URI address = uri.path("/categorias/{id}").buildAndExpand(categoria.getId()).toUri();
        return ResponseEntity.created(address).body(categoria);
    }

    @GetMapping
    public ResponseEntity<Page<Categoria>> findAll(@PageableDefault Pageable pageable) {
        Page<Categoria> categorias = repository.findAll(pageable);
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> GetById(@PathVariable Long id) {
        Categoria categoria = repository.findById(id).orElseThrow(NoSuchElementException::new);

        return ResponseEntity.ok(categoria);
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<Page<Categoria>> GetByNome(@RequestParam String nome, @PageableDefault Pageable pageable) {
        Page<Categoria> categorias = repository.findAllByNomeContainingIgnoreCase(nome, pageable);

        return ResponseEntity.ok(categorias);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> put(@PathVariable Long id, @RequestBody @Valid Categoria categoria) {
        Categoria reference = repository.getReferenceById(id);
        reference.update(categoria);
        return ResponseEntity.ok(repository.save(reference));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        boolean exists = repository.existsById(id);

        if (!exists) {
            throw new NoSuchElementException();
        }

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
