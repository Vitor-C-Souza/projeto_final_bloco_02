package br.com.vitorcsouza.farmacia.model;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "O campo nome não pode estar vazio!")
    @NotBlank(message = "O campo nome não pode estar em branco!")
    private String nome;
    @NotBlank(message = "O campo descrição não pode estar em branco!")
    @NotNull(message = "O campo descrição não pode estar vazio!")
    private String descricao;
    @NotNull(message = "O campo preco não pode estar vazio!")
    private BigDecimal preco;
    @NotNull(message = "O campo estoque não pode estar vazio!")
    private int estoque;


    public void update(@Valid Produto produto) {
        this.nome = produto.getNome();
        this.descricao = produto.getDescricao();
        this.preco = produto.getPreco();
        this.estoque = produto.getEstoque();
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
}
