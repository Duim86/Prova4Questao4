package com.prova4.produto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
  Optional<Produto> findByIdAndEmpresaId(Long produtoId, Long empresaId);
}
