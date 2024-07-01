package br.univille.projeto_petshop_fso2024_a.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.projeto_petshop_fso2024_a.entity.Funcionario;

@Repository
public interface FuncionarioRepository extends JpaRepository<Funcionario,Long> {
    Funcionario findByEmail(String email);
}
