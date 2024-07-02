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
        cliente1.setNome("Felipe Serrano Santos");
        cliente1.setEndereco("Rua Nações Unidas, 333");
        cliente1.setDataNascimento(new Date(2004, 10, 16));
        service.save(cliente1);

        var cliente2 = new Cliente();
        cliente2.setNome("Eduardo Busemayer");
        cliente2.setEndereco("Rua Jaú, 105");
        cliente2.setDataNascimento(new Date(2003, 8, 7));
        service.save(cliente2);

        var cliente3 = new Cliente();
        cliente3.setNome("Ana Maria Silva");
        cliente3.setEndereco("Avenida Paulista, 789");
        cliente3.setDataNascimento(new Date(1995, 2, 20));
        service.save(cliente3);

        var cliente4 = new Cliente();
        cliente4.setNome("Carlos Oliveira");
        cliente4.setEndereco("Rua das Flores, 45");
        cliente4.setDataNascimento(new Date(1988, 11, 5));
        service.save(cliente4);

        var cliente5 = new Cliente();
        cliente5.setNome("Fernanda Costa");
        cliente5.setEndereco("Avenida Brasil, 999");
        cliente5.setDataNascimento(new Date(1992, 4, 15));
        service.save(cliente5);

        var cliente6 = new Cliente();
        cliente6.setNome("Mariana Ferreira");
        cliente6.setEndereco("Rua das Palmeiras, 678");
        cliente6.setDataNascimento(new Date(1990, 6, 10));
        service.save(cliente6);

        var cliente7 = new Cliente();
        cliente7.setNome("Pedro Carvalho");
        cliente7.setEndereco("Rua dos Jacarandás, 321");
        cliente7.setDataNascimento(new Date(1993, 1, 25));
        service.save(cliente7);

        var cliente8 = new Cliente();
        cliente8.setNome("Camila Almeida");
        cliente8.setEndereco("Avenida das Nações, 555");
        cliente8.setDataNascimento(new Date(1985, 3, 30));
        service.save(cliente8);

        var cliente9 = new Cliente();
        cliente9.setNome("Rodrigo Nunes");
        cliente9.setEndereco("Rua das Oliveiras, 444");
        cliente9.setDataNascimento(new Date(1987, 8, 19));
        service.save(cliente9);

        var cliente10 = new Cliente();
        cliente10.setNome("Juliana Lima");
        cliente10.setEndereco("Avenida Central, 222");
        cliente10.setDataNascimento(new Date(1994, 12, 12));
        service.save(cliente10);

        var produto1 = new Produto();
        produto1.setNome("Caixa de Areia");
        produto1.setDescricao("Caixa para de Areia para Gatos");
        produto1.setValorProduto(59.99);
        produto1.setQuantidadeProduto(5);
        produto1.setDataChegadaProduto(new Date(2024, 4, 17));
        produtoService.save(produto1);

        var produto2 = new Produto();
        produto2.setNome("Kit De Banho Pet");
        produto2.setDescricao("Shampoo + Condicionador");
        produto2.setValorProduto(21.90);
        produto2.setQuantidadeProduto(12);
        produto2.setDataChegadaProduto(new Date(2024, 2, 24));
        produtoService.save(produto2);

        var produto3 = new Produto();
        produto3.setNome("Escova");
        produto3.setDescricao("Pente Rasqueadeira de Pet");
        produto3.setValorProduto(154.90);
        produto3.setQuantidadeProduto(7);
        produto3.setDataChegadaProduto(new Date(2024, 6, 8));
        produtoService.save(produto3);

        var produto4 = new Produto();
        produto4.setNome("Colônia P/ Cães E Gatos");
        produto4.setDescricao("Pet Banho E Tosa Petshop, Aroma Bebe");
        produto4.setValorProduto(16.46);
        produto4.setQuantidadeProduto(34);
        produto4.setDataChegadaProduto(new Date(2024, 1, 29));
        produtoService.save(produto4);

        var produto5 = new Produto();
        produto5.setNome("Casa Pet");
        produto5.setDescricao("Casa Pet 3 Em 1 Desmontável C/ Cama Removível");
        produto5.setValorProduto(299.90);
        produto5.setQuantidadeProduto(3);
        produto5.setDataChegadaProduto(new Date(2024, 3, 27));
        produtoService.save(produto5);

        var produto6 = new Produto();
        produto6.setNome("50 laços PET tamanho G sortidos");
        produto6.setDescricao("Petshop/ Banho e Tosa");
        produto6.setValorProduto(34.90);
        produto6.setQuantidadeProduto(100);
        produto6.setDataChegadaProduto(new Date(2024, 6, 01));
        produtoService.save(produto6);

        var produto7 = new Produto();
        produto7.setNome("Meias para Pet");
        produto7.setDescricao("Antiderrapante - Tamanho G");
        produto7.setValorProduto(22.79);
        produto7.setQuantidadeProduto(15);
        produto7.setDataChegadaProduto(new Date(2024, 2, 10));
        produtoService.save(produto7);

        var produto8 = new Produto();
        produto8.setNome("Colete Pet Inverno Impermeável");
        produto8.setDescricao("Rosa / M Peso: 4.5 kg à 6.5 kg");
        produto8.setValorProduto(107.0);
        produto8.setQuantidadeProduto(8);
        produto8.setDataChegadaProduto(new Date(2024, 5, 19));
        produtoService.save(produto8);

        var produto9 = new Produto();
        produto9.setNome("Sanitário Pet");
        produto9.setDescricao("Lavável banheiro higiênico pratico animais domésticos");
        produto9.setValorProduto(46.0);
        produto9.setQuantidadeProduto(17);
        produto9.setDataChegadaProduto(new Date(2024, 1, 5));
        produtoService.save(produto9);

        var produto10 = new Produto();
        produto10.setNome("Arranhador De Gato");
        produto10.setDescricao("Grande Luxuoso Com Casinhas Camas Rede Mighor");
        produto10.setValorProduto(835.90);
        produto10.setQuantidadeProduto(3);
        produto10.setDataChegadaProduto(new Date(2024, 7, 1));
        produtoService.save(produto10);

        var funcionario1 = new Funcionario();
        funcionario1.setNome("Eduardo");
        funcionario1.setCpf("081.458.039.-42");
        funcionario1.setEndereco("Rua Jaú, 105");
        funcionario1.setDataNascimento(new Date(2003, 8, 7));
        funcionario1.setCargo("Admin");
        funcionario1.setEmail("edubusemayer@gmail.com");
        funcionario1.setSenha("Teste");
        funcionarioService.save(funcionario1);

        var funcionario2 = new Funcionario();
        funcionario2.setNome("Carla Mendes");
        funcionario2.setCpf("222.333.444-55");
        funcionario2.setEndereco("Rua dos Animais, 123");
        funcionario2.setDataNascimento(new Date(1990, 8, 15));
        funcionario2.setCargo("Veterinária");
        funcionario2.setEmail("carla.mendes@email.com");
        funcionario2.setSenha("Senha123");
        funcionarioService.save(funcionario2);

        var funcionario3 = new Funcionario();
        funcionario3.setNome("Fernando Oliveira");
        funcionario3.setCpf("333.444.555-66");
        funcionario3.setEndereco("Av. dos Pets, 456");
        funcionario3.setDataNascimento(new Date(1985, 5, 25));
        funcionario3.setCargo("Esteticista");
        funcionario3.setEmail("fernando.oliveira@email.com");
        funcionario3.setSenha("Senha456");
        funcionarioService.save(funcionario3);

        var funcionario4 = new Funcionario();
        funcionario4.setNome("Marina Souza");
        funcionario4.setCpf("444.555.666-77");
        funcionario4.setEndereco("Alameda dos Cães, 789");
        funcionario4.setDataNascimento(new Date(1988, 3, 12));
        funcionario4.setCargo("Atendente");
        funcionario4.setEmail("marina.souza@email.com");
        funcionario4.setSenha("Senha789");
        funcionarioService.save(funcionario4);

        var funcionario5 = new Funcionario();
        funcionario5.setNome("Lucas Santos");
        funcionario5.setCpf("555.666.777-88");
        funcionario5.setEndereco("Rua dos Gatos, 321");
        funcionario5.setDataNascimento(new Date(1995, 7, 8));
        funcionario5.setCargo("Banho e Tosa");
        funcionario5.setEmail("lucas.santos@email.com");
        funcionario5.setSenha("SenhaABC");
        funcionarioService.save(funcionario5);

        var funcionario6 = new Funcionario();
        funcionario6.setNome("Patrícia Costa");
        funcionario6.setCpf("666.777.888-99");
        funcionario6.setEndereco("Travessa dos Pássaros, 654");
        funcionario6.setDataNascimento(new Date(1980, 1, 20));
        funcionario6.setCargo("Gerente");
        funcionario6.setEmail("patricia.costa@email.com");
        funcionario6.setSenha("MinhaSenha123");
        funcionarioService.save(funcionario6);

        var funcionario7 = new Funcionario();
        funcionario7.setNome("Rafaela Silva");
        funcionario7.setCpf("777.888.999-00");
        funcionario7.setEndereco("Praça dos Peixes, 987");
        funcionario7.setDataNascimento(new Date(1992, 11, 30));
        funcionario7.setCargo("Recepcionista");
        funcionario7.setEmail("rafaela.silva@email.com");
        funcionario7.setSenha("SenhaXYZ");
        funcionarioService.save(funcionario7);

        var funcionario8 = new Funcionario();
        funcionario8.setNome("Gustavo Almeida");
        funcionario8.setCpf("888.999.000-11");
        funcionario8.setEndereco("Avenida dos Hamsters, 741");
        funcionario8.setDataNascimento(new Date(1987, 6, 5));
        funcionario8.setCargo("Farmacêutico Veterinário");
        funcionario8.setEmail("gustavo.almeida@email.com");
        funcionario8.setSenha("Senha7890");
        funcionarioService.save(funcionario8);

        var funcionario9 = new Funcionario();
        funcionario9.setNome("Amanda Oliveira");
        funcionario9.setCpf("999.000.111-22");
        funcionario9.setEndereco("Estrada dos Coelhos, 852");
        funcionario9.setDataNascimento(new Date(1998, 9, 18));
        funcionario9.setCargo("Assistente de Veterinário");
        funcionario9.setEmail("amanda.oliveira@email.com");
        funcionario9.setSenha("MinhaSenha456");
        funcionarioService.save(funcionario9);

        var funcionario10 = new Funcionario();
        funcionario10.setNome("Felipe Santos");
        funcionario10.setCpf("000.111.222-33");
        funcionario10.setEndereco("Rua dos Peixes, 963");
        funcionario10.setDataNascimento(new Date(1993, 4, 7));
        funcionario10.setCargo("Auxiliar de Petshop");
        funcionario10.setEmail("felipe.santos@email.com");
        funcionario10.setSenha("Senha1234");
        funcionarioService.save(funcionario10);

        var animalService1 = new Animal();
        animalService1.setNome("Suri");
        animalService1.setTipo("Cachorro");
        animalService1.setRaça("lhasa apso");
        animalService1.setCor("Preto com branco");
        animalService1.setDataNascimento(new Date(2010, 7, 19));
        animalService1.setDono("Felipe Serrano Santos");
        animalService.save(animalService1);

        var animalService2 = new Animal();
        animalService2.setNome("Cacau");
        animalService2.setTipo("Cachorro");
        animalService2.setRaça("Labrador Retriever");
        animalService2.setCor("Chocolate");
        animalService2.setDataNascimento(new Date(2015, 3, 10));
        animalService2.setDono("Eduardo Busemayer");
        animalService.save(animalService2);

        var animalService3 = new Animal();
        animalService3.setNome("Bolinha");
        animalService3.setTipo("Cachorro");
        animalService3.setRaça("Vira-lata");
        animalService3.setCor("Caramelo");
        animalService3.setDataNascimento(new Date(2018, 5, 25));
        animalService3.setDono("Ana Maria Silva");
        animalService.save(animalService3);

        var animalService4 = new Animal();
        animalService4.setNome("Rex");
        animalService4.setTipo("Cachorro");
        animalService4.setRaça("Pastor Alemão");
        animalService4.setCor("Preto");
        animalService4.setDataNascimento(new Date(2017, 9, 12));
        animalService4.setDono("Carlos Oliveira");
        animalService.save(animalService4);

        var animalService5 = new Animal();
        animalService5.setNome("Mel");
        animalService5.setTipo("Cachorro");
        animalService5.setRaça("Golden Retriever");
        animalService5.setCor("Dourado");
        animalService5.setDataNascimento(new Date(2016, 12, 3));
        animalService5.setDono("Fernanda Costa");
        animalService.save(animalService5);

        var animalService6 = new Animal();
        animalService6.setNome("Thor");
        animalService6.setTipo("Cachorro");
        animalService6.setRaça("Rottweiler");
        animalService6.setCor("Preto e Marrom");
        animalService6.setDataNascimento(new Date(2019, 2, 18));
        animalService6.setDono("Mariana Ferreira");
        animalService.save(animalService6);

        var animalService7 = new Animal();
        animalService7.setNome("Luna");
        animalService7.setTipo("Cachorro");
        animalService7.setRaça("Shih Tzu");
        animalService7.setCor("Branco e Marrom");
        animalService7.setDataNascimento(new Date(2014, 8, 7));
        animalService7.setDono("Pedro Carvalho");
        animalService.save(animalService7);

        var animalService8 = new Animal();
        animalService8.setNome("Princesa");
        animalService8.setTipo("Cachorro");
        animalService8.setRaça("Poodle");
        animalService8.setCor("Branco");
        animalService8.setDataNascimento(new Date(2013, 4, 21));
        animalService8.setDono("Camila Almeida");
        animalService.save(animalService8);

        var animalService9 = new Animal();
        animalService9.setNome("Toby");
        animalService9.setTipo("Cachorro");
        animalService9.setRaça("Beagle");
        animalService9.setCor("Tricolor");
        animalService9.setDataNascimento(new Date(2012, 10, 15));
        animalService9.setDono("Rodrigo Nunes");
        animalService.save(animalService9);

        var animalService10 = new Animal();
        animalService10.setNome("Bela");
        animalService10.setTipo("Cachorro");
        animalService10.setRaça("Dachshund");
        animalService10.setCor("Caramelo");
        animalService10.setDataNascimento(new Date(2011, 6, 30));
        animalService10.setDono("Juliana Lima");
        animalService.save(animalService10);

    }
}
