package com.prova4.dtos.inputsdto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProdutoInput {
  private String nome;
  private BigDecimal preco;
}
