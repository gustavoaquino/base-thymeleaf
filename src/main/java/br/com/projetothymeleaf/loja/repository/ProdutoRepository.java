package br.com.projetothymeleaf.loja.repository;

import br.com.projetothymeleaf.loja.domain.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
