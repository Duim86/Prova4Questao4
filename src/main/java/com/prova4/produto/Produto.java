package com.prova4.produto;

import com.prova4.empresa.Empresa;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Table(name = "tb_produto")
public class Produto {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @EqualsAndHashCode.Include
  private Long id;
  private String nome;
  private BigDecimal preco;

  @ManyToOne
  private Empresa empresa;
}
