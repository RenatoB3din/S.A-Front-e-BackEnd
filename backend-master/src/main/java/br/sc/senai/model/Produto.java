package br.sc.senai.model;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @Column(name = "id_produto")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProduto;

    @Column(name = "codigo_produto")
    @Size(max = 20)
    private String cdgProduto;

    @Column(name = "nome_produto")
    @Size(max = 70)
    private String nomeProduto;

    @Column(name = "descricao_produto")
    @Size(max = 150)
    private String descricaoProduto;

    @Column(name = "cod_barras")
    @Size(max = 13)
    private String codBarras;

    @Column(name = "unidade")
    @Size(max = 15)
    private String unidade;

    @Column(name = "perc_sobre_venda")
    private Double percentualSobreVenda;

    @Column(name = "img_url")
    private String imagemURL;

    @Column(name = "qtd_estoque_atual", precision = 10)
    private double qtdEstoqueAtual;

    @Column(name = "valor_venda", precision = 10)
    private double valorVenda;

    @Column(name = "valor_compra", precision = 10)
    private double valorCompra;

    @OneToMany(mappedBy = "produto")
    private Set<MovimentoEstoqueItem> movimentoEstoqueItem;

    public Produto() {
    }

    public Produto(String nomeProduto, String cdgProduto, String descricaoProduto, String codBarras, String unidade, Double percentualSobreVenda, String imagemURL) {
        this.nomeProduto = nomeProduto;
        this.cdgProduto = cdgProduto;
        this.descricaoProduto = descricaoProduto;
        this.codBarras =  codBarras;
        this.unidade = unidade;
        this.percentualSobreVenda = percentualSobreVenda;
        this.imagemURL = imagemURL;
        this.valorCompra = 0D;
        this.valorVenda = 0D;
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

    public String getUnidadeo() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public Double getPercentualSobreVenda() {
        return percentualSobreVenda;
    }

    public void setPercentualSobreVenda(Double percentualSobreVenda) {
        this.percentualSobreVenda = percentualSobreVenda;
    }

    public String getUnidade() {
        return unidade;
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

    public void setQtdEstoqueAtual(double qtdEstoqueAtual) {
        this.qtdEstoqueAtual = atualizaQuantidadeEstoque(qtdEstoqueAtual);
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

    public double atualizaValorVenda(double valorCompra){
        this.valorVenda = valorCompra + ( valorCompra * 0.2 );
        return valorVenda;
    }

    public Set<MovimentoEstoqueItem> getMovimentoEstoqueItem() {
        return movimentoEstoqueItem;
    }

    public void setMovimentoEstoqueItem(Set<MovimentoEstoqueItem> movimentoEstoqueItem) {
        this.movimentoEstoqueItem = movimentoEstoqueItem;
    }

    //ATUALIZA QUANTIDADE ESTOQUE
    public double atualizaQuantidadeEstoque(Double quantidadeMovimento){
        return this.qtdEstoqueAtual = qtdEstoqueAtual + quantidadeMovimento;
    }
}
