package br.com.projetothymeleaf.loja.service;

import br.com.projetothymeleaf.loja.domain.Produto;
import br.com.projetothymeleaf.loja.repository.ProdutoRepository;
import br.com.projetothymeleaf.loja.to.ProdutoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto salvar(Produto produto){
        return this.produtoRepository.save(produto);
    }

    public List<Produto> listarProdutos(){
        return this.produtoRepository.findAll();
    }

    public void deletar(Long id){
        this.produtoRepository.deleteById(id);
    }

    public void atualizar(ProdutoTO produtoTO) {
        Produto produtoAntigo = this.produtoRepository.findById(produtoTO.getId()).get();
        final Produto produto = new Produto(produtoTO);
        produtoAntigo = produto;
        this.produtoRepository.save(produtoAntigo);
    }

    public Produto buscarProdutoById(Long id){
       return this.produtoRepository.findById(id).get();
    }

}
