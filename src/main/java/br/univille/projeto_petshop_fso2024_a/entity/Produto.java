package br.univille.projeto_petshop_fso2024_a.entity;

import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(length = 1000, nullable = false)
    @NotBlank(message = "Campo não pode ser em branco")
    private String nome;
    @Column(length = 1000)
    private String descricao;
    @Column(length = 1000)
    private double valorProduto;
    @Column(length = 1000)
    private int quantidadeProduto;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dataChegadaProduto;
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return descricao;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public double getValorProduto() {
        return valorProduto;
    }
    public void setValorProduto(double valorProduto) {
        this.valorProduto = valorProduto;
    }
    public Date getDataChegadaProduto() {
        return dataChegadaProduto;
    }
    public void setDataChegadaProduto(Date dataChegadaProduto) {
        this.dataChegadaProduto = dataChegadaProduto;
    }
    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }
    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

}
