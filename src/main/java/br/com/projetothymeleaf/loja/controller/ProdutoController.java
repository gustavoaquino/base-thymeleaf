package br.com.projetothymeleaf.loja.controller;

import br.com.projetothymeleaf.loja.domain.Produto;
import br.com.projetothymeleaf.loja.service.ProdutoService;
import br.com.projetothymeleaf.loja.to.ProdutoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    /*
    @GetMapping
    public ModelAndView exibir(){
        final List<Produto> produtoList = this.produtoService.listarProdutos();

        final ModelAndView modelAndView = new ModelAndView("produtos");

        modelAndView.addObject("produtoList", produtoList);

        return modelAndView;
    }
    */

    @GetMapping
    public String exibir(Model model){
        final List<Produto> produtoList = this.produtoService.listarProdutos();
        model.addAttribute("produtoList", produtoList);
        return "produtos";
    }

    @GetMapping("/cadastrar")
    public String exibirFormCadastro(){
        return "cadastro-produtos";
    }

    @PostMapping("/cadastrar")
    public String salvarFormCadastro(ProdutoTO produtoTO){
        final Produto produto = new Produto(produtoTO);
        this.produtoService.salvar(produto);
        return "redirect:/produtos";
    }


}
