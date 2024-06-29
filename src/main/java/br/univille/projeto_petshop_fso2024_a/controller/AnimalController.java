package br.univille.projeto_petshop_fso2024_a.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.univille.projeto_petshop_fso2024_a.entity.Animal;
import br.univille.projeto_petshop_fso2024_a.service.AnimalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/animais")
public class AnimalController {
    @Autowired
    private AnimalService service;

    @GetMapping
    public ModelAndView index(){
        var listaAnimais = service.getAll();
        return new ModelAndView("animal/index", "listaAnimais", listaAnimais);
    }

    @GetMapping("/novo")
    public ModelAndView novo() {
        var animal = new Animal();
        return new ModelAndView("animal/form","animal",animal);
    }
    
    @PostMapping
    public ModelAndView save(Animal animal) {
        service.save(animal);
        return new ModelAndView("redirect:/animais");
    }

    @GetMapping("/alterar/{id}")
    public ModelAndView alterar(@PathVariable("id") long id) {
        var animal = service.getById(id);
        return new ModelAndView("animal/form", "animal", animal);
    }
    
    @GetMapping("/delete/{id}")
    public ModelAndView delete(@PathVariable("id") long id){
        service.delete(id);
        return new ModelAndView("redirect:/animais");
    }
}
