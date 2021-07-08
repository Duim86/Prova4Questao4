package com.prova4.dtos.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmpresaModel {
  private Long id;
  private String nome;
  private List<ProdutoResumoModel> produtos;
}
