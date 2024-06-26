package br.univille.projeto_petshop_fso2024_a.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.univille.projeto_petshop_fso2024_a.entity.Funcionario;
import br.univille.projeto_petshop_fso2024_a.repository.FuncionarioRepository;
import br.univille.projeto_petshop_fso2024_a.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl implements FuncionarioService {
    
    @Autowired
    private FuncionarioRepository repository;

    @Override
    public void save(Funcionario funcionario) {
        repository.save(funcionario);
    }

    @Override
    public Funcionario getById(long id) {
        return repository.getById(id);
    }

    @Override
    public List<Funcionario> getAll() {
        return repository.findAll();
    }  
    
    @Override
    public Funcionario delete(long id) {
        var funcionario = getById(id);
        repository.deleteById(id);
        return funcionario;
    }

    @Override
    public Funcionario authenticate(String email, String senha) {
        Funcionario funcionario = repository.findByEmail(email);
        if (funcionario != null && funcionario.getSenha().equals(senha)) {
            return funcionario;
        }
        return null; // Retornar null se as credenciais não forem válidas
    }
}
