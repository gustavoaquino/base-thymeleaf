package br.com.projetothymeleaf.loja.controller;

import br.com.projetothymeleaf.loja.domain.Produto;
import br.com.projetothymeleaf.loja.service.ProdutoService;
import br.com.projetothymeleaf.loja.to.ProdutoTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
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

    /*Cadastrar*/
    @GetMapping("/cadastrar")
    public String exibirFormCadastro(){
        return "form-produto";
    }

    @PostMapping("/cadastrar")
    public String salvarFormCadastro(@Valid ProdutoTO produtoTO, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("error", true);
            return "form-produto";
        }

        final Produto produto = new Produto(produtoTO);
        this.produtoService.salvar(produto);
        return "redirect:/produtos";
    }

    /*Atualizar*/
    @GetMapping("/atualizar/{id}")
    public String atualizarFormProduto(@PathVariable("id") Long id, Model model){
        final Produto produto = this.produtoService.buscarProdutoById(id);
        model.addAttribute("produto", produto);
        model.addAttribute("editar", true);
        return "form-produto";
    }

    @PostMapping("/atualizar")
    public String atualizarFormProduto(ProdutoTO produtoTO){
        this.produtoService.atualizar(produtoTO);
        return "redirect:/produtos";
    }

    /*Deletar*/
    @GetMapping("/deletar/{id}")
    public String deletarProduto(@PathVariable("id") Long id){
        this.produtoService.deletar(id);
        return "redirect:/produtos";
    }

}
