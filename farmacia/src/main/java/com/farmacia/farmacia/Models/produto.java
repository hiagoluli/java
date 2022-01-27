package com.farmacia.farmacia.Models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Accessors(chain = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class produto implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //gera id automaticamente
    private long id;

    private String descricao;
    private double preco;
    private int quantidade;
    private String categoria;
    private boolean generico;
    private boolean promocao;
    private double precoPromocional;
    private String imagem;

/*
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return this.preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isGenerico() {
        return this.generico;
    }

    public boolean getGenerico() {
        return this.generico;
    }

    public void setGenerico(boolean generico) {
        this.generico = generico;
    }

    public boolean isPromocao() {
        return this.promocao;
    }

    public boolean getPromocao() {
        return this.promocao;
    }

    public void setPromocao(boolean promocao) {
        this.promocao = promocao;
    }

    public double getPrecoPromocional() {
        return this.precoPromocional;
    }

    public void setPrecoPromocional(double precoPromocional) {
        this.precoPromocional = precoPromocional;
    }

    public String getImagem() {
        return this.imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
*/
}
