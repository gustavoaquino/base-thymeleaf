package br.com.projetothymeleaf.loja.service;

import br.com.projetothymeleaf.loja.domain.Produto;
import br.com.projetothymeleaf.loja.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto){
        return this.produtoRepository.save(produto);
    }

}