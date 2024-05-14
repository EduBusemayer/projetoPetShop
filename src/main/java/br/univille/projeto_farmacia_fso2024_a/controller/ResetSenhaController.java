package br.univille.projeto_farmacia_fso2024_a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/senha")
public class ResetSenhaController {
    @GetMapping
    public ModelAndView index() {
        return new ModelAndView("home/senha");    
    }
}
