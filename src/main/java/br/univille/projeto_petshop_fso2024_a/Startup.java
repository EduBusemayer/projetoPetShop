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
        cliente1.setDataNascimento(new Date(2004,10,16));
        service.save(cliente1);

        var produto1 = new Produto();
        produto1.setNome("Caixa de Areia");
        produto1.setDescricao("Caixa para de Areia para Gatos");
        produto1.setValorProduto(59.99);
        produto1.setQuantidadeProduto(5);
        produto1.setDataChegadaProduto(new Date(2024,4,17));
        produtoService.save(produto1);

        var produto2 = new Produto();
        produto2.setNome("Kit De Banho Pet");
        produto2.setDescricao("Shampoo + Condicionador");
        produto2.setValorProduto(21.90);
        produto2.setQuantidadeProduto(12);
        produto2.setDataChegadaProduto(new Date(2024,2,24));
        produtoService.save(produto2);

        var produto3 = new Produto();
        produto3.setNome("Escova");
        produto3.setDescricao("Pente Rasqueadeira de Pet");
        produto3.setValorProduto(154.90);
        produto3.setQuantidadeProduto(7);
        produto3.setDataChegadaProduto(new Date(2024,6,8));
        produtoService.save(produto3);

        var produto4 = new Produto();
        produto4.setNome("Colônia P/ Cães E Gatos");
        produto4.setDescricao("Pet Banho E Tosa Petshop, Aroma Bebe");
        produto4.setValorProduto(16.46);
        produto4.setQuantidadeProduto(34);
        produto4.setDataChegadaProduto(new Date(2024,1,29));
        produtoService.save(produto4);

        var produto5 = new Produto();
        produto5.setNome("Casa Pet");
        produto5.setDescricao("Casa Pet 3 Em 1 Desmontável C/ Cama Removível");
        produto5.setValorProduto(299.90);
        produto5.setQuantidadeProduto(3);
        produto5.setDataChegadaProduto(new Date(2024,3,27));
        produtoService.save(produto5);

        var produto6 = new Produto();
        produto6.setNome("50 laços PET tamanho G sortidos");
        produto6.setDescricao("Petshop/ Banho e Tosa");
        produto6.setValorProduto(34.90);
        produto6.setQuantidadeProduto(100);
        produto6.setDataChegadaProduto(new Date(2024,6,01));
        produtoService.save(produto6);

        var produto7 = new Produto();
        produto7.setNome("Meias para Pet");
        produto7.setDescricao("Antiderrapante - Tamanho G");
        produto7.setValorProduto(22.79);
        produto7.setQuantidadeProduto(15);
        produto7.setDataChegadaProduto(new Date(2024,2,10));
        produtoService.save(produto7);

        var produto8 = new Produto();
        produto8.setNome("Colete Pet Inverno Impermeável");
        produto8.setDescricao("Rosa / M Peso: 4.5 kg à 6.5 kg");
        produto8.setValorProduto(107.0);
        produto8.setQuantidadeProduto(8);
        produto8.setDataChegadaProduto(new Date(2024,5,19));
        produtoService.save(produto8);

        var produto9 = new Produto();
        produto9.setNome("Sanitário Pet");
        produto9.setDescricao("Lavável banheiro higiênico pratico animais domésticos");
        produto9.setValorProduto(46.0);
        produto9.setQuantidadeProduto(17);
        produto9.setDataChegadaProduto(new Date(2024,1,5));
        produtoService.save(produto9);

        var produto10 = new Produto();
        produto10.setNome("Arranhador De Gato");
        produto10.setDescricao("Grande Luxuoso Com Casinhas Camas Rede Mighor");
        produto10.setValorProduto(835.90);
        produto10.setQuantidadeProduto(3);
        produto10.setDataChegadaProduto(new Date(2024,7,1));
        produtoService.save(produto10);

        var funcionario1 = new Funcionario();
        funcionario1.setNome("Eduardo");
        funcionario1.setCpf("081.458.039.-42");
        funcionario1.setEndereco("Rua Jaú, 105");
        funcionario1.setDataNascimento(new Date(2003,8,7));
        funcionario1.setCargo("Boss");
        funcionario1.setEmail("edubusemayer@gmail.com");
        funcionario1.setSenha("T3st3");
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
