package br.univille.projeto_farmacia_fso2024_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import br.univille.projeto_farmacia_fso2024_a.entity.Produto;
import br.univille.projeto_farmacia_fso2024_a.service.ProdutoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/produtos")
public class ProdutoController {
    
    @Autowired
    private ProdutoService service;

    @GetMapping
    public ModelAndView index() {
        var listaProdutos = service.getAll();
        return new ModelAndView("produto/index","listaProdutos",listaProdutos);
    }
    
    @GetMapping("/novo")
    public ModelAndView novo() {
        var produto = new Produto();
        return new ModelAndView("produto/form","produto",produto);
    }

    @PostMapping
    public ModelAndView save(Produto produto) {
        service.save(produto);
        return new ModelAndView("redirect:/produtos");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var produto = service.getById(id);
        return new ModelAndView("produto/form", "produto", produto);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/produtos");
    }
}
