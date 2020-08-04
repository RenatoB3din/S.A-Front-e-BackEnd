package br.sc.senai.model;

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
    private MovimentoEstoque movimentoEstoque;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    private Produto produto;

    private Double valor;

    private Double qtde;

    public MovimentoEstoqueItem() {
    }

    public MovimentoEstoqueItem(Double valor, Double qtde) {
        this.valor = valor;
        this.qtde = qtde;
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
}
