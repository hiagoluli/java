package com.farmacia.farmacia.Models;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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

    @NotEmpty(message = "O nome do produto não pode ser vazio")
    @NotNull(message = "O nome do produto não pode ser nulo")
    private String descricao;
    private double preco;
    private int quantidade;
    private String categoria;
    private boolean generico;
    private boolean promocao;
    private double precoPromocional;
    private String imagem;

}
