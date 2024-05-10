package br.univille.projeto_farmacia_fso2024_a;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import br.univille.projeto_farmacia_fso2024_a.entity.Cliente;
import br.univille.projeto_farmacia_fso2024_a.entity.Produto;
import br.univille.projeto_farmacia_fso2024_a.service.ClienteService;
import br.univille.projeto_farmacia_fso2024_a.service.ProdutoService;

@Component
public class Startup {
    
    @Autowired
    private ClienteService service;

    @Autowired
    private ProdutoService produtoService; 

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
        produto1.setDataChegadaProduto(new Date(2024, 4, 17));
        produtoService.save(produto1);
        
    }

}
