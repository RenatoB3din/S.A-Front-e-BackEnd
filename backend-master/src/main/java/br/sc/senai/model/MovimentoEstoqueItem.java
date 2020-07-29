package br.sc.senai.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "relmovimentoestoqueitem")
public class MovimentoEstoqueItem {

    @Id
    @Column(name = "id_movimentosestoqueitem")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMovimentoEstoqueItem;

    @ManyToOne
    @JoinColumn(name = "movimentoestoque_id")
    private MovimentoEstoque movimentoEstoque;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Produto produtoEstoque;

    private LocalDateTime registeredAt;

    public MovimentoEstoqueItem() {
    }

//    public MovimentoEstoqueItem(Double qtdMovimento, Double vlrUnitario){
//        this.qtdMovimento = qtdMovimento;
//        this.vlrUnitario = vlrUnitario;
//    }

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

//    public Double getQtdMovimento() {
//        return qtdMovimento;
//    }
//
//    public void setQtdMovimento(Double qtdMovimento) {
//        this.qtdMovimento = qtdMovimento;
//    }
//
//    public Double getVlrUnitario() {
//        return vlrUnitario;
//    }
//
//    public void setVlrUnitario(Double vlrUnitario) {
//        this.vlrUnitario = vlrUnitario;
//    }

    public LocalDateTime getRegisteredAt() {
        return registeredAt;
    }

    public void setRegisteredAt(LocalDateTime registeredAt) {
        this.registeredAt = registeredAt;

    }

    public Produto getProdutoEstoque() {
        return produtoEstoque;
    }

    public void setProdutoEstoque(Produto produtoEstoque) {
        this.produtoEstoque = produtoEstoque;
    }
}
