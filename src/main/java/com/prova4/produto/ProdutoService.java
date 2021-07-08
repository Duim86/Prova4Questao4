package com.prova4.produto;

import com.prova4.empresa.Empresa;
import com.prova4.empresa.EmpresaRepository;
import com.prova4.empresa.EmpresaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {
  @Autowired
  private EmpresaService empresaService;

  @Autowired
  private ProdutoRepository produtoRepository;

  public Produto salvar(Long empresaId, Produto produto) {
    var empresa = empresaService.findOrFail(empresaId);

    produto.setEmpresa(empresa);
    return produtoRepository.save(produto);
  }

  public Produto findOrFail(Long produtoId, Long empresaId) {
    return produtoRepository.findByIdAndEmpresaId(produtoId, empresaId)
            .orElseThrow(() -> new IllegalStateException("Produto não encontrado"));
  }
}
