package br.com.projetothymeleaf.loja.repository;

import br.com.projetothymeleaf.loja.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
