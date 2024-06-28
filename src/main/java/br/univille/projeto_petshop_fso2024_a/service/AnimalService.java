package br.univille.projeto_petshop_fso2024_a.service;

import java.util.List;

import br.univille.projeto_petshop_fso2024_a.entity.Animal;

public interface AnimalService {
    void save(Animal animal);
    Animal getById(long id);
    List<Animal> getAll();
    Animal delete(long id);
}