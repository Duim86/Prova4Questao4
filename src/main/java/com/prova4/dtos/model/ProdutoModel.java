package com.prova4.dtos.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoModel {
  private Long id;
  private String nome;
  private String empresaNome;
  private BigDecimal preco;
}
