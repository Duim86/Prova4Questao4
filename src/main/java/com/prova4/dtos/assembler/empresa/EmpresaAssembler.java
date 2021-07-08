package com.prova4.dtos.assembler.empresa;

import com.prova4.dtos.model.EmpresaListModel;
import com.prova4.dtos.model.EmpresaModel;
import com.prova4.empresa.Empresa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;


@Component
public class EmpresaAssembler {

  @Autowired
  private ModelMapper modelMapper;

  public EmpresaModel toModel(Empresa empresa) {
    return modelMapper.map(empresa, EmpresaModel.class);
  }

  public EmpresaListModel toModelList(Empresa empresa) {
    return modelMapper.map(empresa, EmpresaListModel.class);
  }

  public List<EmpresaListModel> toCollectionModel(List<Empresa> empresas) {
    return empresas.stream().map(this::toModelList).collect(Collectors.toList());
  }

}

