package br.sc.senai.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "venda_item")
public class VendaItem {

    @Id
    @Column(name = "id_venda_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idVendaItem;

    @ManyToOne
    @JoinColumn(name = "id_venda")
    @JsonIgnore
    private Venda venda;

    @ManyToOne
    @JoinColumn(name = "id_produto")
    @JsonIgnore
    private Produto produto;

    @Column(name = "nome_produto_vendido")
    private String nomeproduto;

    @Column(name = "nome_cliente_venda")
    private String clientevenda;

    @Column(name = "nome_vendedor_venda")
    private String vendedorvenda;

    @Column(name = "nr_cupomfiscal_da_venda")
    private String cupomfiscalVenda;

    @Column(name = "tipopagamento_venda")
    private Enum tipopagamento;

    @Column(name = "data_venda")
    private String dataVenda;

    @Column(name = "qtde_item_venda")
    private Double qtde;

    @Column(name = "valor_item_venda")
    private Double valorUnitario;
    
    @Column(name = "valordesconto_item_venda")
    private Double valorDesconto;

    @Column(name = "valorTot_venda")
    private Double valorTotal;

    @Column(name = "valorbruto_item_venda")
    private Double valorTotalBruto;

    private String messageError;


    public VendaItem(){

    }

    public VendaItem(Integer idVendaItem, Venda venda, Produto produto, Double qtde, Double valorUnitario, Double valorTotalBruto, Double valorDesconto, Double valorTotal) {
        this.idVendaItem = idVendaItem;
        this.venda = venda;
        this.produto = produto;
        this.qtde = qtde;
        this.valorUnitario = valorUnitario;
        this.valorTotalBruto = valorTotalBruto;
        this.valorDesconto = valorDesconto;
        this.valorTotal = valorTotalBruto - valorDesconto;
    }

    public String getClientevenda() {
        return clientevenda;
    }

    public void setClientevenda(String clientevenda) {
        this.clientevenda = clientevenda;
    }

    public String getVendedorvenda() {
        return vendedorvenda;
    }

    public void setVendedorvenda(String vendedorvenda) {
        this.vendedorvenda = vendedorvenda;
    }

    public String getCupomfiscalVenda() {
        return cupomfiscalVenda;
    }

    public void setCupomfiscalVenda(String cupomfiscalVenda) {
        this.cupomfiscalVenda = cupomfiscalVenda;
    }

    public Enum getTipopagamento() {
        return tipopagamento;
    }

    public void setTipopagamento(Enum tipopagamento) {
        this.tipopagamento = tipopagamento;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getNomeproduto() {
        return nomeproduto;
    }

    public void setNomeproduto(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    public String getMessageError() {
        return messageError;
    }

    public void setMessageError(String messageError) {
        this.messageError = messageError;
    }

    public Integer getIdVendaItem() {
        return idVendaItem;
    }

    public void setIdVendaItem(Integer idVendaItem) {
        this.idVendaItem = idVendaItem;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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

    public Double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Double valorUnitario) {
        this.valorUnitario = valorUnitario;
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

    public double atualizaValorVenda(double valorTotalBruto, double valorDesconto) {
        this.valorTotal = (valorTotalBruto - valorDesconto);
        return valorTotal;
    }
}
