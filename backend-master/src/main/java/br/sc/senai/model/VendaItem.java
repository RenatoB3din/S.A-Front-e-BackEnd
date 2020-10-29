package br.sc.senai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "venda_item")
public class VendaItem {

    @Id
    @Column(name = "id_venda_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVenaItem;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    @JsonIgnore
    private Venda venda;

    private Integer nrItemVenda;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    @JsonIgnore
    private Produto produto;

    private Double qtde;

    private Double valorUntario;

    private Double valorTotalBruto;

    private Double valorDesconto;

    private Double valorTotal;

    public VendaItem(){

    }

    public VendaItem(Integer idVenaItem, Venda venda, Integer nrItemVenda, Produto produto, Double qtde, Double valorUntario) {
        this.idVenaItem = idVenaItem;
        this.venda = venda;
        this.nrItemVenda = nrItemVenda;
        this.produto = produto;
        this.qtde = qtde;
        this.valorUntario = valorUntario;
    }

    public Integer getIdVenaItem() {
        return idVenaItem;
    }

    public void setIdVenaItem(Integer idVenaItem) {
        this.idVenaItem = idVenaItem;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }

    public Integer getNrItemVenda() {
        return nrItemVenda;
    }

    public void setNrItemVenda(Integer nrItemVenda) {
        this.nrItemVenda = nrItemVenda;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Double getQtde() {
        return qtde;
    }

    public void setQtde(Double qtde) {
        this.qtde = qtde;
    }

    public Double getValorUntario() {
        return valorUntario;
    }

    public void setValorUntario(Double valorUntario) {
        this.valorUntario = valorUntario;
    }

    public Double getValorTotalBruto() {
        return valorTotalBruto;
    }

    public void setValorTotalBruto(Double valorTotalBruto) {
        this.valorTotalBruto = valorTotalBruto;
    }

    public Double getValorDesconto() {
        return valorDesconto;
    }

    public void setValorDesconto(Double valorDesconto) {
        this.valorDesconto = valorDesconto;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
