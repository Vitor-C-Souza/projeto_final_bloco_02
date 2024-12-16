package br.com.vitorcsouza.farmacia.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "tb_categorias")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O campo nome não pode estar vazio!")
    @NotBlank(message = "O campo nome não pode estar em branco!")
    private String nome;
    @NotBlank(message = "O campo descrição não pode estar em branco!")
    @NotNull(message = "O campo descrição não pode estar vazio!")
    private String descricao;

    public void update(@Valid Categoria categoria) {
        this.nome = categoria.getNome();
        this.descricao = categoria.getDescricao();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
