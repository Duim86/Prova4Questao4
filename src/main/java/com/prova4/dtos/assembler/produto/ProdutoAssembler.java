package com.prova4.dtos.assembler.produto;

import com.prova4.dtos.model.ProdutoListModel;
import com.prova4.dtos.model.ProdutoModel;
import com.prova4.dtos.model.ProdutoResumoModel;
import com.prova4.produto.Produto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class ProdutoAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public ProdutoModel toModel(Produto produto) {
    return modelMapper.map(produto, ProdutoModel.class);
  }

  public ProdutoResumoModel toResumoModel(Produto produto) {
    return modelMapper.map(produto, ProdutoResumoModel.class);
  }

  public ProdutoListModel toModelList(Produto produto) {
    return modelMapper.map(produto, ProdutoListModel.class);
  }

  public List<ProdutoListModel> toCollectionModel(List<Produto> produtos) {
    return produtos.stream().map(this::toModelList).collect(Collectors.toList());
  }

}

