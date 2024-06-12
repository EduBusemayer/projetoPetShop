package br.univille.projeto_petshop_fso2024_a.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.projeto_petshop_fso2024_a.entity.Produto;
import br.univille.projeto_petshop_fso2024_a.repository.ProdutoRepository;
import br.univille.projeto_petshop_fso2024_a.service.ProdutoService;

@Service
public class ProdutoServiceImpl implements ProdutoService {
    @Autowired
    private ProdutoRepository repository;

    @Override
    public void save(Produto produto){
        repository.save(produto);
    }
    @Override
    public Produto getById(long id){
        return repository.getById(id);
    }
    @Override
    public List<Produto> getAll(){
        return repository.findAll();
    }
    @Override
    public Produto delete(long id){
        var produto = getById(id);
        repository.deleteById(id);
        return produto;
    }
}
