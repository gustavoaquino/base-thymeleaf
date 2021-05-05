package br.com.projetothymeleaf.loja.controller;

import br.com.projetothymeleaf.loja.to.ProdutoTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @GetMapping
    public String exibir(){
       return "produtos";
    }

    @GetMapping("/cadastrar")
    public String exibirFormCadastro(){
        return "cadastro-produtos";
    }

    @PostMapping("/cadastrar")
    public String salvarFormCadastro(ProdutoTO produtoTO){
        return "produtos";
    }


}
