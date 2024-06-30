package br.univille.projeto_petshop_fso2024_a;

import java.time.LocalDate;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import br.univille.projeto_petshop_fso2024_a.entity.Animal;
import br.univille.projeto_petshop_fso2024_a.entity.Cliente;
import br.univille.projeto_petshop_fso2024_a.entity.Funcionario;
import br.univille.projeto_petshop_fso2024_a.entity.Produto;
import br.univille.projeto_petshop_fso2024_a.service.AnimalService;
import br.univille.projeto_petshop_fso2024_a.service.ClienteService;

import br.univille.projeto_petshop_fso2024_a.service.FuncionarioService;
import br.univille.projeto_petshop_fso2024_a.service.ProdutoService;

@Component
public class Startup {
    
    @Autowired
    private ClienteService service;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private FuncionarioService funcionarioService; 

    @Autowired
    private AnimalService animalService;

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        var cliente1 = new Cliente();
        cliente1.setNome("Zezinho");
        cliente1.setEndereco("Rua lalalala 100");
        cliente1.setDataNascimento(new Date(2024,04,17));
        service.save(cliente1);

        var produto1 = new Produto();
        produto1.setNome("Produto 1");
        produto1.setDescricao("Descrição do Produto 1");
        produto1.setValorProduto(10.0); // Alterado para double
        produto1.setQuantidadeProduto(5);
        produto1.setDataChegadaProduto(new Date(2024,4,17));
        produtoService.save(produto1);

        var funcionario1 = new Funcionario();
        funcionario1.setNome("Eduardo");
        funcionario1.setCpf("081.458.039.-42");
        funcionario1.setEndereco("Rua Jaú, 105");
        funcionario1.setDataNascimento(new Date(2003,8,7));
        funcionario1.setCargo("Boss");
        funcionario1.setEmail("edubusemayer@gmail.com");
        funcionarioService.save(funcionario1);

        var animalService1 = new Animal();
        animalService1.setNome("Suri");
        animalService1.setTipo("Cachorro");
        animalService1.setRaça("lhasa apso");
        animalService1.setCor("Preto com branco");
        animalService1.setDataNascimento(new Date(2010, 7, 19));
        animalService1.setDono("Felipe Serrano Santos");
        animalService.save(animalService1);
    }
}
