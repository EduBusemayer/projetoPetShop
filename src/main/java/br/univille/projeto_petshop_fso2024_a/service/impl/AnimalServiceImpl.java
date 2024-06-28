package br.univille.projeto_petshop_fso2024_a.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projeto_petshop_fso2024_a.entity.Animal;
import br.univille.projeto_petshop_fso2024_a.repository.AnimalRepository;
import br.univille.projeto_petshop_fso2024_a.service.AnimalService;

@Service
public class AnimalServiceImpl implements AnimalService {

    @Autowired
    private AnimalRepository repository;

    @Override
    public void save(Animal animal) {
        repository.save(animal);
    }

    @Override
    public Animal getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Animal> getAll() {
        return repository.findAll();
    }

    @Override
    public Animal delete(long id) {
        var animal = getById(id);
        repository.deleteById(id);
        return animal;
    }
}
