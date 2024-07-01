package br.univille.projeto_petshop_fso2024_a.service;

import java.util.List;
import br.univille.projeto_petshop_fso2024_a.entity.Funcionario;

public interface FuncionarioService {
    void save(Funcionario funcionario);
    Funcionario getById(long id);
    List<Funcionario> getAll();
    Funcionario delete(long id);
    Funcionario authenticate(String email, String senha);
}
