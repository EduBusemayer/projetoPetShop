package br.univille.projeto_farmacia_fso2024_a.service;

import java.util.List;
import br.univille.projeto_farmacia_fso2024_a.entity.Produto;

public interface ProdutoService {
    void save(Produto produto);
    Produto getById(long id);
    List<Produto> getAll();
    Produto delete(long id);
} 
