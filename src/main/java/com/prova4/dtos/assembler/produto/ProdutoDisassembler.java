package com.prova4.dtos.assembler.produto;

import com.prova4.dtos.inputsdto.ProdutoInput;
import com.prova4.produto.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDisassembler {
  @Autowired
  private ModelMapper modelMapper;

  public Produto toEntity(ProdutoInput produto) {
    return modelMapper.map(produto, Produto.class);
  }
}
