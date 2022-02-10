package com.farmacia.farmacia.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoDTO {

    private String descricao;
    private double preco;
    private int quantidade;
    private String categoria;
    private boolean generico;
    private boolean promocao;
    private double precoPromocional;
    private String imagem;

    
}
