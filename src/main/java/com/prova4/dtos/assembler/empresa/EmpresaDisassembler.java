package com.prova4.dtos.assembler.empresa;

import com.prova4.dtos.inputsdto.EmpresaInput;
import com.prova4.empresa.Empresa;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmpresaDisassembler {
  @Autowired
  private ModelMapper modelMapper;

  public Empresa toEntity(EmpresaInput empresa) {
    return modelMapper.map(empresa, Empresa.class);
  }
}
