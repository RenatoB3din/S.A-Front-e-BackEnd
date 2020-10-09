package br.sc.senai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "movimento_estoque_item")
public class MovimentoEstoqueItem {

    @Id
    @Column(name = "id_movimento_sestoque_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimentoEstoqueItem;

    @ManyToOne
    @JoinColumn(name = "id_movimento_estoque")
    @JsonIgnore
    private MovimentoEstoque movimentoEstoque;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    @JsonIgnore
    private Produto produto;

    private Double valor;

    private Double qtde;

    private Double lote;

    private String validade;

    public MovimentoEstoqueItem() {
    }

    public MovimentoEstoqueItem(Produto produto, Double valor, Double qtde, Double lote, String validade) {
        this.valor = valor;
        this.qtde = qtde;
        this.lote = lote;
        this.validade = validade;
    }

    public Integer getIdMovimentoEstoqueItem() {
        return idMovimentoEstoqueItem;
    }

    public void setIdMovimentoEstoqueItem(Integer idMovimentoEstoqueItem) {
        this.idMovimentoEstoqueItem = idMovimentoEstoqueItem;
    }

    public MovimentoEstoque getMovimentoEstoque() {
        return movimentoEstoque;
    }

    public void setMovimentoEstoque(MovimentoEstoque movimentoEstoque) {
        this.movimentoEstoque = movimentoEstoque;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getQtde() {
        return qtde;
    }

    public void setQtde(Double qtde) {
        this.qtde = qtde;
    }

    public Double getLote() {
        return lote;
    }

    public void setLote(Double lote) {
        this.lote = lote;
    }

    public String getValidade() {
        return validade;
    }

    public void setValidade(String validade) {
        this.validade = validade;
    }
}
