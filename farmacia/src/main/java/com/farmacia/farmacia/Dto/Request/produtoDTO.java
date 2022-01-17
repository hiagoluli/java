package com.farmacia.farmacia.Dto.Request;

import com.farmacia.farmacia.Models.produto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class produtoDTO {

    private String descricao;
    private double preco;
    private int quantidade;
    private String categoria;
    private boolean generico;
    private boolean promocao;
    private double precoPromocional;
    private String imagem;

    public produto build(){
        produto prod = new produto().setDescricao(this.descricao)
                                    .setPreco(this.preco)
                                    .setQuantidade(this.quantidade)
                                    .setCategoria(this.categoria)
                                    .setGenerico(this.generico)
                                    .setPromocao(this.promocao)
                                    .setPrecoPromocional(this.precoPromocional)
                                    .setImagem(this.imagem);

        return prod;

    }
    
}
