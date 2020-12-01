package br.sc.senai.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import javax.print.DocFlavor;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name = "produto",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "cdgProduto"),
        })
public class Produto {

    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;

    @NotBlank
    @Size(max = 20)
    private String cdgProduto;

    @NotBlank
    @Column(name = "nome_produto")
    @Size(max = 70)
    private String nomeProduto;

    @NotBlank
    @Column(name = "descricao_produto")
    @Size(max = 150)
    private String descricaoProduto;

    @NotBlank
    @Column(name = "cod_barras")
    @Size(max = 13)
    private String codBarras;

    @Column(name = "perc_sobre_venda")
    private Double percentualSobreVenda;

    @NotBlank
    @Column(name = "img_url")
    private String imagemURL;


    @Column(name = "qtd_estoque_atual", precision = 10)
    private double qtdEstoqueAtual;

    @Column(name = "valor_venda", precision = 10)
    private double valorVenda;

    @Column(name = "valor_compra", precision = 10)
    private double valorCompra;


    @OneToMany(mappedBy = "produto", orphanRemoval=true)
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private Set<MovimentoEstoqueItem> movimentoEstoqueItem;


    @OneToMany(mappedBy = "produto", orphanRemoval=true)
    @Cascade(value = org.hibernate.annotations.CascadeType.DELETE_ORPHAN)
    private Set<VendaItem> vendaItem;

    public Produto() {
    }

    public Produto(String nomeProduto, String cdgProduto, String descricaoProduto, String codBarras, Double percentualSobreVenda, String imagemURL) {
        this.nomeProduto = nomeProduto;
        this.cdgProduto = cdgProduto;
        this.descricaoProduto = descricaoProduto;
        this.codBarras = codBarras;
        this.percentualSobreVenda = percentualSobreVenda;
        this.imagemURL = imagemURL;
        this.valorCompra = 0D;
        this.valorVenda = 0D;
    }



    public Set<VendaItem> getVendaItem() {
        return vendaItem;
    }

    public void setVendaItem(Set<VendaItem> vendaItem) {
        this.vendaItem = vendaItem;
    }

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getCdgProduto() {
        return cdgProduto;
    }

    public void setCdgProduto(String cdgProduto) {
        this.cdgProduto = cdgProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getCodBarras() {
        return codBarras;
    }

    public void setCodBarras(String codBarras) {
        this.codBarras = codBarras;
    }

    public Double getPercentualSobreVenda() {
        return percentualSobreVenda;
    }

    public void setPercentualSobreVenda(Double percentualSobreVenda) {
        this.percentualSobreVenda = percentualSobreVenda;
    }

    public String getImagemURL() {
        return imagemURL;
    }

    public void setImagemURL(String imagemURL) {
        this.imagemURL = imagemURL;
    }

    public double getQtdEstoqueAtual() {
        return qtdEstoqueAtual;
    }

    public void setQtdEstoqueAtual(double qtdEstoqueAtual, Enum tipoMovimento) throws Exception {
        this.qtdEstoqueAtual = atualizaQuantidadeEstoque(qtdEstoqueAtual, tipoMovimento);
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public double atualizaValorVenda(double valorCompra, double percentualSobreVenda) {
        this.valorVenda = valorCompra + (valorCompra * percentualSobreVenda/100);
        return valorVenda;
    }

    public Set<MovimentoEstoqueItem> getMovimentoEstoqueItem() {
        return movimentoEstoqueItem;
    }

    public void setMovimentoEstoqueItem(Set<MovimentoEstoqueItem> movimentoEstoqueItem) {
        this.movimentoEstoqueItem = movimentoEstoqueItem;
    }

    //ATUALIZA QUANTIDADE ESTOQUE
    public double atualizaQuantidadeEstoque(Double quantidadeMovimento, Enum tipoMovimento) throws Exception {

        String tpMovimentoEstoque = tipoMovimento.toString();

        if ("MOV_VENDA".equals(tpMovimentoEstoque) || "MOV_DEVOLUCAO_FORNECEDOR".equals(tpMovimentoEstoque)) {

            if (this.qtdEstoqueAtual >= quantidadeMovimento) {

                this.qtdEstoqueAtual -= quantidadeMovimento;

            } else {

                throw new Exception("Estoque insuficiente");

            }

        } else if ("MOV_COMPRA".equals(tpMovimentoEstoque) || "MOV_DEVOLUCAO_CLIENTE".equals(tpMovimentoEstoque)) {

            this.qtdEstoqueAtual += quantidadeMovimento;

        } else if ("MOV_INVENTARIO_ESTOQUE".equals(tpMovimentoEstoque)) {

            this.qtdEstoqueAtual = quantidadeMovimento;

        } else {

            // TODO: 22/08/2020 >> Colocar uma excessão
            System.out.println("Opção inválida");
        }

        return this.qtdEstoqueAtual;

    }


}
