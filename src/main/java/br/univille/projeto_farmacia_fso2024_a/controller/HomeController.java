package br.univille.projeto_farmacia_fso2024_a.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/")
public class HomeController {
    @GetMapping
    //@ResponseBody
    //public String index() {
    //    return "MÃE, eu não acredito";
    //}
    public ModelAndView index() {
        return new ModelAndView("home/index");    
    }
}
