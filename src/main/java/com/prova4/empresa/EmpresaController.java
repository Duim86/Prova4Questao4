package com.prova4.empresa;

import com.prova4.dtos.assembler.empresa.EmpresaAssembler;
import com.prova4.dtos.assembler.empresa.EmpresaDisassembler;
import com.prova4.dtos.assembler.produto.ProdutoAssembler;
import com.prova4.dtos.assembler.produto.ProdutoDisassembler;
import com.prova4.dtos.inputsdto.EmpresaInput;
import com.prova4.dtos.inputsdto.ProdutoInput;
import com.prova4.dtos.model.EmpresaListModel;
import com.prova4.dtos.model.EmpresaModel;
import com.prova4.dtos.model.ProdutoModel;
import com.prova4.dtos.model.ProdutoResumoModel;
import com.prova4.produto.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/empresas")
public class EmpresaController {

  @Autowired
  private EmpresaRepository empresaRepository;

  @Autowired
  private EmpresaService empresaService;

  @Autowired
  private ProdutoService produtoService;

  @Autowired
  private EmpresaAssembler empresaAssembler;

  @Autowired
  private EmpresaDisassembler empresaDisassembler;

  @Autowired
  private ProdutoDisassembler produtoDisassembler;

  @Autowired
  private ProdutoAssembler produtoAssembler;

  @GetMapping
  public List<EmpresaListModel> listAll() {
    return empresaAssembler.toCollectionModel(empresaRepository.findAll());
  }

  @GetMapping("/{empresaId}")
  public EmpresaModel findById(@PathVariable Long empresaId) {
    return empresaAssembler.toModel(empresaService.findOrFail(empresaId));
  }

  @PostMapping
  public Empresa save(@RequestBody EmpresaInput empresaInput) {
    return empresaRepository.save(empresaDisassembler.toEntity(empresaInput));
  }

  @PostMapping("/{empresaId}/produto/{produtoId}")
  public ProdutoModel findByIdProduto(@PathVariable Long produtoId, @PathVariable Long empresaId) {
    empresaService.findOrFail(empresaId);
    var produto = produtoService.findOrFail(produtoId, empresaId);
    return produtoAssembler.toModel(produto);
  }

  @PostMapping("/{empresaId}/produto")
  public ProdutoResumoModel saveProduto(@RequestBody ProdutoInput produtoInput, @PathVariable Long empresaId) {
    var produto = produtoService.salvar(empresaId, produtoDisassembler.toEntity(produtoInput));
    return produtoAssembler.toResumoModel(produto);
  }

}

