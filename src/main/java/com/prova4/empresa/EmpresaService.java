package com.prova4.empresa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpresaService {

  @Autowired
  private EmpresaRepository empresaRepository;

  public Empresa findOrFail(Long empresaId) {
    return empresaRepository.findById(empresaId)
            .orElseThrow(() -> new IllegalStateException("Empresa de id " + empresaId + " não encontrada"));
  }
}
