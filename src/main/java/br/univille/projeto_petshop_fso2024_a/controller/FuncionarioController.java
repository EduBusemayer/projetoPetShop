package br.univille.projeto_petshop_fso2024_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.projeto_petshop_fso2024_a.entity.Funcionario;
import br.univille.projeto_petshop_fso2024_a.service.FuncionarioService;

@Controller
@RequestMapping("/funcionarios")
public class FuncionarioController {
    
    @Autowired
    private FuncionarioService service;

    @Autowired
    private FuncionarioService funcionarioService;

    // Página de login
    @GetMapping("/")
    public String loginPage() {
        return "index"; // Nome do arquivo HTML de login
    }

    // Método para processar o login
    @PostMapping("/login")
    public ModelAndView login(@RequestParam String email, @RequestParam String senha, Model model) {
    Funcionario funcionario = funcionarioService.authenticate(email, senha);
    if (funcionario != null) {
        ModelAndView modelAndView = new ModelAndView("home/home");
        modelAndView.addObject("nomeFuncionario", funcionario.getNome());
        modelAndView.addObject("cargoFuncionario", funcionario.getCargo());
        return modelAndView;
    } else {
        model.addAttribute("error", "Email ou senha incorretos.");
        model.addAttribute("email", email);
        model.addAttribute("senha", senha);
        return new ModelAndView("redirect:/").addObject("error", "Credenciais inválidas. Por favor, tente novamente.");
    }
}

    @GetMapping
    public ModelAndView index() {
        var listaFuncionarios = service.getAll();
        return new ModelAndView("funcionario/index","listaFuncionarios",listaFuncionarios);
    }
    
    @GetMapping("/novo")
    public ModelAndView novo() {
        var funcionario = new Funcionario();
        return new ModelAndView("funcionario/form","funcionario",funcionario);
    }

    @PostMapping
    public ModelAndView save(Funcionario funcionario) {
        service.save(funcionario);
        return new ModelAndView("redirect:/funcionarios");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var funcionario = service.getById(id);
        return new ModelAndView("funcionario/form", "funcionario", funcionario);
    }

    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/funcionarios");
    }
}
