package br.univille.projeto_farmacia_fso2024_a.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projeto_farmacia_fso2024_a.entity.Cliente;
import br.univille.projeto_farmacia_fso2024_a.repository.ClienteRepository;
import br.univille.projeto_farmacia_fso2024_a.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{
    
    @Autowired
    private ClienteRepository repository;

    @Override
    public void save(Cliente cliente) {
        repository.save(cliente);
    }
    @Override
    public Cliente getById(long id) {
        return repository.getById(id);
    }
    @Override
    public List<Cliente> getAll() {
        return repository.findAll();
    }  
}
