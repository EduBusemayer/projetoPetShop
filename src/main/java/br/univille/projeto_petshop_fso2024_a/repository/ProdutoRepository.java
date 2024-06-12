package br.univille.projeto_petshop_fso2024_a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projeto_petshop_fso2024_a.entity.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto,Long> {
    
}
